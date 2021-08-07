package org.jeycode.localab.utils.files;

import static org.springframework.util.StringUtils.getFilenameExtension;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.jeycode.localab.config.GenericUtilsConfig;

/**
 * 
 * En este objeto helper se aglutinan métodos de utilidad para tratamiento de
 * los ficheros de los task. Se creará un solo objeto (singleton) y en su inicio
 * se cargarán los set de valores del EnumMap, esto se estable en la clase de
 * configuración.
 * 
 * @see GenericUtilsConfig
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         5 ago. 2021
 *
 */
public class LabFilesHelper
{

      public final LabFilesValidator dirValidator = paths-> Stream.of(paths)
                                                                  .map(Path::toFile)
                                                                  .allMatch(File::isDirectory);

      public final LabFilesValidator fileValidator = paths-> Stream.of(paths)
                                                                   .map(Path::toFile)
                                                                   .allMatch(File::isFile);

      public boolean isHtml(String filePath)
      {
            return isValidFileExtension(filePath,FileExtension.HTML);
      }

      public boolean isCss(String filePath)
      {
            return isValidFileExtension(filePath,FileExtension.CSS);
      }

      public boolean isJS(String filePath)
      {
            return isValidFileExtension(filePath,FileExtension.JS);
      }

      public boolean isDoc(String filePath)
      {
            return isValidFileExtension(filePath,FileExtension.DOC);
      }

      public boolean isImg(String filePath)
      {
            return isValidFileExtension(filePath,FileExtension.IMG);
      }

      public boolean isValidFileExtension(String filePath,FileExtension fileExtension)
      {
            return fileExtensionMap.get(fileExtension)
                                   .contains(getFilenameExtension(filePath));
      }

      public boolean checkIfExistsThis(Path path)
      {
            return path.toFile()
                       .exists();
      }

      Map<FileExtension,Set<String>> fileExtensionMap = new EnumMap<>(FileExtension.class);

      public void loadEnumMapValues()
      {
            FileExtension html = FileExtension.HTML;
            fileExtensionMap.put(html,new HashSet<>(Arrays.asList("html","htm")));
            fileExtensionMap.put(FileExtension.CSS,new HashSet<>(Arrays.asList("css","sass")));
            fileExtensionMap.put(FileExtension.JS,new HashSet<>(Arrays.asList("js","ts")));
            fileExtensionMap.put(FileExtension.IMG,new HashSet<>(Arrays.asList("jpg","png","jpeg","svg")));
            fileExtensionMap.put(FileExtension.DOC,
                                 new HashSet<>(Arrays.asList("pdf","docx","txt","xlsx","xls","yml","json","xml","ppt","pptx")));

      }

      public enum FileExtension
      {
       HTML,
       CSS,
       JS,
       IMG,
       DOC
      }

      public boolean generateTaskSimpleStructure()
      {
            // TODO Auto-generated method stub
            return false;
      }

      public boolean generateTaskDefaultStructure()
      {
            // TODO Auto-generated method stub
            return false;
      }
}
