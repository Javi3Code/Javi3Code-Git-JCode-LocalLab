package org.jeycode.localab.filesworker;

import java.nio.file.Path;

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

      boolean createTaskModelStructure(Path path,boolean allLocalesDir);

      boolean deleteTaskModelStructure(Path path);

      boolean copyFile(Path source,Path target);

      boolean copyDir(Path source,Path target);

}
