package org.jeycode.localab.filesworker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.jeycode.localab.utils.files.LabFilesHelper;
import org.jeycode.localab.utils.files.LabFilesValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Clase que se encarga de los trabajos pesados con archivos o directorios.
 * 
 * @see FileWorker
 * @see LabFileVisitor
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         5 ago. 2021
 *
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class LabFileWorker implements FileWorker
{

      private final LabFilesHelper filesHelper;

      @Override
      public boolean copyFile(Path source,Path target)
      {
            try
            {
                  Path fileParentDirPath = target.getParent();
                  if (filesHelper.checkIfExistsThis(fileParentDirPath))
                  {
                        log.info("El directorio donde se quiere copiar el archivo no existe, es posible que algún directorio padre de este tampoco, nos aseguramos de crear todos..."
                                                + " --- dir[ " + fileParentDirPath + " ]");
                        Files.createDirectories(fileParentDirPath);
                  }
                  Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);
                  log.info("Se ha copidado el archivo [ " + source + " ] en [ " + target.getParent() + " ]");
                  return true;
            }
            catch (IOException ex)
            {
                  log.error("Problemas al intentar copiar un archivo..." + "\n" + ex.getMessage());
                  return false;
            }
      }

      @Override
      public boolean copyDir(Path source,Path target)
      {
            return copy(source,target,filesHelper.dirValidator);
      }

      @Override
      public boolean createTaskModelStructure(Path path,boolean allLocalesDir)
      {
            try
            {
                  if (!filesHelper.checkIfExistsThis(path))
                  {
                        Files.createDirectories(path);
                  }
                  if (allLocalesDir)
                  {
                        return filesHelper.generateTaskDefaultStructure();
                  }
                  return filesHelper.generateTaskSimpleStructure();
            }
            catch (IOException ex)
            {
                  return false;
            }
      }

      @Override
      public boolean deleteTaskModelStructure(Path path)
      {
            String okLogMsg = "Se ha borrado correctamente el 'Task'";
            String errLogMsg = "No se ha podido borrar correctamente el 'Task'";
            try
            {
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

      private boolean copy(Path source,Path target,LabFilesValidator validator)
      {
            try
            {
                  boolean areValidPath = validator.validate(source,target);
                  FileSystemUtils.copyRecursively(source,target);
                  return true;
            }
            catch (IOException ex)
            {
                  return false;
            }
      }

}
