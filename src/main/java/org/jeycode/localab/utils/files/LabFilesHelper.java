package org.jeycode.localab.utils.files;

import static org.springframework.util.StringUtils.getFilenameExtension;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

      public boolean isHtml(String filePath)
      {
            return isValidFileExtension(filePath,FileExtension.HTML);
      }

      public boolean isValidFileExtension(String filePath,FileExtension fileExtension)
      {
            return fileExtensionMap.get(fileExtension)
                                   .contains(getFilenameExtension(filePath));
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
}
