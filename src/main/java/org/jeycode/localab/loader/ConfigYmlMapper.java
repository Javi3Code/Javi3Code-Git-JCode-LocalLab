package org.jeycode.localab.loader;

import static org.jeycode.localab.utils.GenericHelper.CONFIG_YML;
import static org.jeycode.localab.utils.GenericHelper.EMPTY_STRING;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.taskmodel.model.YMLObj;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 
 * Clase para cargar YML de configuración de la aplicación. Implementa
 * {@link GenericYmlMapper} Establece la clase a mapear.
 * 
 * 
 * @see AppConfigObj
 * 
 * @author Javier Pérez Alonso
 *
 *         21 jul. 2021
 *
 */

public class ConfigYmlMapper implements GenericYmlMapper
{

      @Override
      public Class<? extends YMLObj> getClassObjToReturn()
      {
            return AppConfigObj.class;
      }

      @Override
      public AppConfigObj loadYmlFile(String file) throws JsonParseException,JsonMappingException,IOException
      {
            Path filePath = Paths.get(EMPTY_STRING)
                                 .resolve(file);
            if (!Files.exists(filePath))
            {
                  throw new IOException("No se ha encontrado el archivo de configuración.\n"
                                          + "Archivo config yml bien formado:\n\t-Debe llamarse " + CONFIG_YML
                                          +"\n\t-Puedes consultar el config.yml de ejemplo para crearlo, si lo borraste podrás encontrarlo ahora de nuevo."
                                          + "\n\t-Debe ubicarse en el mismo directorio que el ejecutable.");
            }
            return (AppConfigObj)GenericYmlMapper.super.loadYmlFile(file);
      }


}
