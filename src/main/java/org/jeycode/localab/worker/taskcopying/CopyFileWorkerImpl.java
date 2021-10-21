package org.jeycode.localab.worker.taskcopying;

import static org.jeycode.localab.utils.GenericHelper.ASYNC_EXECUTOR;
import static org.jeycode.localab.utils.files.LabFilesStaticHelper.checkIfExistsThis;
import static org.jeycode.localab.utils.files.LabFilesStaticHelper.reentrantLock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.CompletableFuture;

import org.jeycode.localab.utils.files.LabFilesStaticHelper;
import org.jeycode.localab.utils.files.LabFilesValidator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Clase que se encarga de los trabajos pesados con archivos o directorios.
 * 
 * @see CopyFileWorker
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         5 ago. 2021
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CopyFileWorkerImpl implements CopyFileWorker
{

      @Override
      @Async(ASYNC_EXECUTOR)
      public CompletableFuture<Boolean> copyFileAsync(Path source,Path target)
      {
            return CompletableFuture.supplyAsync(()-> copyFile(source,target));

      }

      @Override
      public Boolean copyFile(Path source,Path target)
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

      @Override
      @Async(ASYNC_EXECUTOR)
      public CompletableFuture<Boolean> copyDirAsync(Path source,Path target)
      {
            return CompletableFuture.supplyAsync(()-> copyDir(source,target));

      }

      @Override
      public Boolean copyDir(Path source,Path target)
      {
            return copyWithValidation(source,target,LabFilesStaticHelper.allPathsAreDirValidator);
      }

    

      /*
       * Private Methods
       * ------------------------------------------------------------------
       */

     

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

}
