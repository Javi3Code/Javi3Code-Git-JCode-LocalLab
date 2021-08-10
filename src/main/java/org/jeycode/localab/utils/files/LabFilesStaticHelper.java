package org.jeycode.localab.utils.files;

import static org.springframework.util.StringUtils.getFilenameExtension;

import java.io.File;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * 
 * @author Javier Pérez Alonso
 *
 *         8 ago. 2021
 *
 */

public interface LabFilesStaticHelper
{

      ReentrantLock reentrantLock = new ReentrantLock();

      /*
       * Validadores -> Predicados para validar diferentes cosas relacionadas con los
       * Path de los archivos o directorios usados en las operaciones de la
       * aplciación.
       */
      LabFilesValidator allPathsAreDirValidator = paths-> Stream.of(paths)
                                                                .map(Path::toFile)
                                                                .allMatch(File::isDirectory);

      LabFilesValidator allPathsAreFileValidator = paths-> Stream.of(paths)
                                                                 .map(Path::toFile)
                                                                 .allMatch(File::isFile);

      LabFilesValidator allTaskFilesAreUniques = paths-> (paths.length == Stream.of(paths)
                                                                                .distinct()
                                                                                .count());


      Map<FileExtension,Set<String>> fileExtensionMap = new EnumMap<>(FileExtension.class);

      public enum FileExtension
      {
       HTML,
       CSS,
       JS,
       IMG,
       DOC
      }
      
     static boolean isValidFileExtension(String filePath,FileExtension fileExtension)
      {
            return fileExtensionMap.get(fileExtension)
                                   .contains(getFilenameExtension(filePath));
      }

      static boolean checkIfExistsThis(Path path)
      {
            return path.toFile()
                       .exists();
      }

}
