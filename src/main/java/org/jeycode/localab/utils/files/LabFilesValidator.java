package org.jeycode.localab.utils.files;

import java.nio.file.Path;

/**
 * 
 * Interface funcional usada para validar los path.
 * 
 * @author Javier Pérez Alonso
 *
 *         5 ago. 2021
 *
 */
@FunctionalInterface
public interface LabFilesValidator
{

      boolean validate(Path... paths);

}
