package org.jeycode.localab.worker.taskcompressing;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

import org.jeycode.localab.utils.files.LabFilesStaticHelper.FileExtension;

public interface TaskModelWorker
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
}
