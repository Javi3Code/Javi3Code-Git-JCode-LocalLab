package org.jeycode.localab.filesworker;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

import org.jeycode.localab.utils.files.LabFilesStaticHelper.FileExtension;

/**
 * 
 * Interface que determina el contrato a firmar por las clases que se encargarán
 * de las operaciones pesadas con archivos o directorios.
 * 
 * @author Javier Pérez Alonso
 *
 *         5 ago. 2021
 *
 */
public interface FileWorker 
{

      /**
       * 
       * Method createTaskModelStructure
       *
       * @param path
       * @param allLocalesDir : Defiene si se quieren los directorios para los diferentes idiomas valorados.
       * @return Si se ha realizado con éxito la operación.
       */
      Boolean createTaskModelStructure(Path path,boolean allLocalesDir);

      CompletableFuture<Boolean> createTaskModelStructureAsync(Path path,boolean allLocalesDir);

      Boolean createTaskModelSpecializedStructure(Path path,FileExtension extension);

      CompletableFuture<Boolean> createTaskModelSpecializedStructureAsync(Path path,FileExtension extension);

      Boolean deleteTaskModelStructure(Path path);

      CompletableFuture<Boolean> deleteTaskModelStructureAsync(Path path);

      Boolean copyFile(Path source,Path target);

      CompletableFuture<Boolean> copyFileAsync(Path source,Path target);

      Boolean copyDir(Path source,Path target);

      CompletableFuture<Boolean> copyDirAsync(Path source,Path target);
}
