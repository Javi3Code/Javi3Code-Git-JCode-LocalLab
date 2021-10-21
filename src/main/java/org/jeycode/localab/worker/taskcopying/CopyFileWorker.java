package org.jeycode.localab.worker.taskcopying;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

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
public interface CopyFileWorker 
{

      Boolean copyFile(Path source,Path target);

      CompletableFuture<Boolean> copyFileAsync(Path source,Path target);

      Boolean copyDir(Path source,Path target);

      CompletableFuture<Boolean> copyDirAsync(Path source,Path target);
}
