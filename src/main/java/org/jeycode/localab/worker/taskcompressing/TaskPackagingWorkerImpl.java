package org.jeycode.localab.worker.taskcompressing;

import static org.jeycode.localab.utils.GenericHelper.ASYNC_EXECUTOR;
import static org.jeycode.localab.utils.GenericHelper.ORIGIN_BACKUP;
import static org.jeycode.localab.utils.GenericHelper.PARENT_TASKFILES_DIR;
import static org.jeycode.localab.utils.GenericHelper.TASK_BACKUP;
import static org.jeycode.localab.utils.files.LabFilesStaticHelper.checkIfExistsThis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Stream;

import org.jeycode.localab.applicationcontext.model.ApplicationContext;
import org.jeycode.localab.utils.LocaleRef;
import org.jeycode.localab.utils.files.LabFilesStaticHelper.FileExtension;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskPackagingWorkerImpl implements TaskModelWorker
{

      private final ApplicationContext applicationContext;

      @Override @Async(ASYNC_EXECUTOR)
      public CompletableFuture<Boolean> createTaskModelStructureAsync(Path path,boolean allLocalesDir)
      {
            return CompletableFuture.supplyAsync(()-> createTaskModelStructure(path,allLocalesDir));
      }

      @Override @Async(ASYNC_EXECUTOR)
      public CompletableFuture<Boolean> createTaskModelSpecializedStructureAsync(Path path,FileExtension extension)
      {
            return CompletableFuture.supplyAsync(()-> createTaskModelSpecializedStructure(path,extension));
      }

      @Override
      public Boolean createTaskModelStructure(Path path,boolean allLocalesDir)
      {
            try
            {
                  log.info("Se va a intentar crear el TaskModelStructure.");
                  createParentTaskDirIfNotExists(path);

                  return tryToGenerateTaskModelStructure(path,allLocalesDir);
            }
            catch (IOException ex)
            {
                  return false;
            }
      }

      @Override
      public Boolean createTaskModelSpecializedStructure(Path path,FileExtension extension)
      {
            try
            {
                  log.info("Se va a intentar crear el TaskModelStructure especializada para archivos " + extension + ".");
                  createParentTaskDirIfNotExists(path);
                  createBuckupsDirectories(path);
                  Path fileParentDir = tryToCreateTaskFilesParentDirAndReturnIt(path);
                  Path extensionFilePath = createPathWithEnumName(fileParentDir).apply(extension);
                  log.info(String.format("Se ha creado el directorio para guardar los ficheros " + extension + ". " + extensionFilePath));
                  if (extension == FileExtension.HTML)
                  {
                        createAllHTMLLocaleDir(extensionFilePath);
                  }
                  return true;
            }
            catch (IOException ex)
            {
                  log.error("Ocurrió un error en el proceso de creación del TaskModelSpecializedStructure. " + ex.getMessage());
                  return false;
            }
      }

      private void createParentTaskDirIfNotExists(Path path) throws IOException
      {
            if (!checkIfExistsThis(path))
            {
                  log.info("No existe el directorio padre donde crear el TaskModelStructure. Se procede a crearlo.");
                  Files.createDirectories(path);
                  log.info("Se ha creado el directorio padre donde crear el TaskModelStructure.");
            }
      }

      private boolean tryToGenerateTaskModelStructure(Path path,boolean allLocalesDir)
      {
            try
            {
                  String msg = allLocalesDir ? "Se intenta crear un TaskModelStructure con todas las carpetas para idiomas." :
                        "Se intenta crear un TaskModelStructure sin carpetas para el resto de idiomas.";
                  log.info(msg);
                  Path parentTaskFilesParent = tryToCreateTaskFilesParentDirAndReturnIt(path);
                  tryToCreateTaskFilesSubDir(parentTaskFilesParent,allLocalesDir);
                  createBuckupsDirectories(path);
                  return true;
            }
            catch (IOException | RuntimeException ex)
            {
                  log.error("Ocurrió un error en el proceso de creación del TaskModelStructure. " + ex.getMessage());
                  return false;
            }
      }

      private void createBuckupsDirectories(Path path) throws IOException
      {
            Files.createDirectory(path.resolve(ORIGIN_BACKUP));
            Files.createDirectory(path.resolve(TASK_BACKUP));
      }

      private Path tryToCreateTaskFilesParentDirAndReturnIt(Path path) throws IOException
      {
            Path parentTaskFilesParent = createFileParentDir(path);
            return parentTaskFilesParent;
      }

      private void tryToCreateTaskFilesSubDir(Path parentTaskFilesParent,boolean allLocalesDir)
      {
            log.info("Se va a crear los subdirectorios de " + parentTaskFilesParent);
            Stream.of(FileExtension.values())
                  .map(createPathWithEnumName(parentTaskFilesParent))
                  .forEach(this::tryToCreateDir);
            if (allLocalesDir)
            {
                  createAllHTMLLocaleDir(parentTaskFilesParent);
            }

      }

      private Path createFileParentDir(Path path) throws IOException
      {
            Path parentTaskFilesParent = path.resolve(PARENT_TASKFILES_DIR);
            Files.createDirectory(parentTaskFilesParent);
            return parentTaskFilesParent;
      }

      private void createAllHTMLLocaleDir(Path parentTaskFilesParent)
      {
            log.info("Se dispone a crear los directorios html para cada lenguaje.");
            Path htmlDir = parentTaskFilesParent.resolve(FileExtension.HTML.name());
            applicationContext.getActiveWorkspace()
                              .getLocaleRefs()
                              .stream()
                              .filter(ref-> ref != LocaleRef.ALL)
                              .map(createPathWithEnumName(htmlDir))
                              .forEach(this::tryToCreateDir);
      }

      private Function<Enum<?>,? extends Path> createPathWithEnumName(Path parentTaskFilesParent)
      {
            return enumVal-> parentTaskFilesParent.resolve(enumVal.name());
      }

      private void tryToCreateDir(Path pathComplete)
      {
            try
            {
                  log.info("Se intenta crear " + pathComplete);
                  Files.createDirectory(pathComplete);
            }
            catch (IOException ex)
            {
                  throw new RuntimeException("Error al tratar de crear " + pathComplete);
            }
      }

}
