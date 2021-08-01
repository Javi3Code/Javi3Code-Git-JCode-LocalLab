package org.jeycode.localab.utils.files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 
 * En esta interface de utilidades se encapsulan métodos helper para el
 * tratamiento de los path.
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         1 ago. 2021
 *
 */
public interface PathFormatter
{

      static Path createPathWithThis(List<String> pathParts)
      {
            return Paths.get(pathParts.stream()
                                      .reduce(String::concat)
                                      .get());
      }

      static String format(String path)
      {
            return Paths.get(path)
                        .toString();
      }

}
