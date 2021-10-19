package org.jeycode.localab.filesworker;

import static org.jeycode.localab.utils.ApplicationContext.activeWorkspace;
import static org.jeycode.localab.utils.GenericHelper.ASYNC_EXECUTOR;
import static org.jeycode.localab.utils.GenericHelper.ORIGIN_BACKUP;
import static org.jeycode.localab.utils.GenericHelper.PARENT_TASKFILES_DIR;
import static org.jeycode.localab.utils.GenericHelper.TASK_BACKUP;
import static org.jeycode.localab.utils.files.LabFilesStaticHelper.checkIfExistsThis;
import static org.jeycode.localab.utils.files.LabFilesStaticHelper.reentrantLock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Stream;

import org.jeycode.localab.utils.LocaleRef;
import org.jeycode.localab.utils.files.LabFilesStaticHelper;
import org.jeycode.localab.utils.files.LabFilesStaticHelper.FileExtension;
import org.jeycode.localab.utils.files.LabFilesValidator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.FileSystemUtils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Clase que se encarga de los trabajos pesados con archivos o directorios.
 * 
 * @see FileWorker
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         5 ago. 2021
 *
 */
@Slf4j
@UtilityClass
public class LabFileWorker
{

      @Async(ASYNC_EXECUTOR)
      public static CompletableFuture<Boolean> copyFileAsync(Path source,Path target)
      {
            return CompletableFuture.supplyAsync(()-> copyFile(source,target));

      }

      public static Boolean copyFile(Path source,Path target)
      {
            try
            {

                  Path fileParentDirPath = target.getParent();
                  checkIfExistParentDirIfNotCreateDirectoriesSync(fileParentDirPath);
                  Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);
                  log.info("Se ha copiado el archivo [ " + source + " ] en [ " + target.getParent() + " ]");
                  return true;

            }
            catch (IOException ex)
            {
                  log.error("Problemas al intentar copiar un archivo..." + "\n" + ex.getMessage());
                  return false;
            }
      }

      @Async(ASYNC_EXECUTOR)
      public static CompletableFuture<Boolean> copyDirAsync(Path source,Path target)
      {
            return CompletableFuture.supplyAsync(()-> copyDir(source,target));

      }

      public static Boolean copyDir(Path source,Path target)
      {
            return copyWithValidation(source,target,LabFilesStaticHelper.allPathsAreDirValidator);
      }

      @Async(ASYNC_EXECUTOR)
      public static CompletableFuture<Boolean> createTaskModelStructureAsync(Path path,boolean allLocalesDir)
      {
            return CompletableFuture.supplyAsync(()-> createTaskModelStructure(path,allLocalesDir));
      }

      public static Boolean createTaskModelStructure(Path path,boolean allLocalesDir)
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

      public static Boolean deleteTaskModelStructure(Path path)
      {
            String okLogMsg = "Se ha borrado correctamente el 'Task'";
            String errLogMsg = "No se ha podido borrar correctamente el 'Task'";
            try
            {
                  log.info("Se procede a borrar el TaskModelStructure.");
                  boolean deleteRecursively = FileSystemUtils.deleteRecursively(path);
                  String logMsg = deleteRecursively ? okLogMsg : errLogMsg;
                  log.info(logMsg);
                  return deleteRecursively;
            }
            catch (IOException ex)
            {
                  log.error(errLogMsg);
                  return false;
            }
      }

      @Async(ASYNC_EXECUTOR)
      public static CompletableFuture<Boolean> deleteTaskModelStructureAsync(Path path)
      {
            return CompletableFuture.supplyAsync(()-> deleteTaskModelStructure(path));
      }

      public static Boolean createTaskModelSpecializedStructure(Path path,FileExtension extension)
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

      @Async(ASYNC_EXECUTOR)
      public static CompletableFuture<Boolean> createTaskModelSpecializedStructureAsync(Path path,FileExtension extension)
      {
            return CompletableFuture.supplyAsync(()-> createTaskModelSpecializedStructure(path,extension));
      }

      /*
       * Private Methods
       * ------------------------------------------------------------------
       */

      private void createParentTaskDirIfNotExists(Path path) throws IOException
      {
            if (!checkIfExistsThis(path))
            {
                  log.info("No existe el directorio padre donde crear el TaskModelStructure. Se procede a crearlo.");
                  Files.createDirectories(path);
                  log.info("Se ha creado el directorio padre donde crear el TaskModelStructure.");
            }
      }

      private void checkIfExistParentDirIfNotCreateDirectoriesSync(Path fileParentDirPath) throws IOException
      {
            try
            {
                  reentrantLock.lock();
                  log.info("Se ha bloqueado el recurso para checkear paths en paralelo");
                  if (!checkIfExistsThis(fileParentDirPath))
                  {
                        log.info("El directorio donde se quiere copiar el archivo no existe, es posible que algún directorio padre de este tampoco, nos aseguramos de crear todos..."
                                                + " --- dir[ " + fileParentDirPath + " ]");
                        Files.createDirectories(fileParentDirPath);
                  }
            }
            finally
            {
                  log.info("Se ha finalizado la operación de checkear el path y se procede al desbloqueo");
                  reentrantLock.unlock();
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

      private Path createFileParentDir(Path path) throws IOException
      {
            Path parentTaskFilesParent = path.resolve(PARENT_TASKFILES_DIR);
            Files.createDirectory(parentTaskFilesParent);
            return parentTaskFilesParent;
      }

      private void tryToCreateTaskFilesSubDir(Path parentTaskFilesParent,boolean allLocalesDir)
      {
            log.info("Se va a crear los subdirectorios de " + parentTaskFilesParent);
            Stream.of(FileExtension.values())
                  .map(createPathWithEnumName(parentTaskFilesParent))
                  .forEach(LabFileWorker::tryToCreateDir);
            if (allLocalesDir)
            {
                  createAllHTMLLocaleDir(parentTaskFilesParent);
            }

      }

      private void createAllHTMLLocaleDir(Path parentTaskFilesParent)
      {
            log.info("Se dispone a crear los directorios html para cada lenguaje.");
            Path htmlDir = parentTaskFilesParent.resolve(FileExtension.HTML.name());
            activeWorkspace.getLocaleRefs()
                           .stream()
                           .filter(ref-> ref != LocaleRef.ALL)
                           .map(createPathWithEnumName(htmlDir))
                           .forEach(LabFileWorker::tryToCreateDir);
      }

      private boolean copyWithValidation(Path source,Path target,LabFilesValidator validator)
      {
            try
            {
                  boolean areValidPath = validator.validate(source,target);
                  if (areValidPath)
                  {
                        log.info("Se han validado los Path y se procede a realizar copias.");
                        FileSystemUtils.copyRecursively(source,target);
                        log.info("Se han realizado las copias pertinentes.");
                        return true;
                  }
                  throw new IOException("No son paths válidos para realizar la copia.");
            }
            catch (IOException ex)
            {
                  log.error("Ha ocurrido un error en la operación de copia con validación. " + ex.getMessage());
                  return false;
            }
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
