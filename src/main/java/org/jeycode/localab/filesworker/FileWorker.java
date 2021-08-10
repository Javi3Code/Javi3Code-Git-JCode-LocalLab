package org.jeycode.localab.filesworker;

import java.nio.file.Path;

import org.jeycode.localab.utils.GenericHelper;

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
public interface FileWorker extends GenericHelper
{

      Boolean createTaskModelStructure(Path path,boolean allLocalesDir);

      boolean deleteTaskModelStructure(Path path);

      Boolean copyFile(Path source,Path target);

      Boolean copyDir(Path source,Path target);

}
