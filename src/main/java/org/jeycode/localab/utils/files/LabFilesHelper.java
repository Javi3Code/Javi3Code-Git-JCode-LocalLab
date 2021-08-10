package org.jeycode.localab.utils.files;

import java.util.Arrays;
import java.util.HashSet;

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
public class LabFilesHelper implements LabFilesStaticHelper
{

   

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

}
