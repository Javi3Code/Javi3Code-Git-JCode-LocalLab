package org.jeycode.localab.loader;

import static org.jeycode.localab.loader.GenericYmlMapper.CONFIGMAPPER;
import static org.jeycode.localab.utils.GenericHelper.EMPTY_STRING;
import static org.jeycode.localab.utils.GenericHelper.SUFFIX_CONFIG_YML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.taskmodel.model.YMLObj;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

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

@RequiredArgsConstructor
@Component(value = CONFIGMAPPER)
@Scope("singleton")
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
            if (!validConfigFile(filePath))
            {
                  throw new IOException("El archivo de configuración escogido no es un archivo válido.\n"
                                          + "Archivo config yml bien formado:\n" + "\t-Debe terminar en " + SUFFIX_CONFIG_YML
                                          + "\n\t-Para seleccionarlo introduce como argumento el nombre corto sin lo anterior,"
                                          + "\n\t-Debe ubicarse en el mismo directorio que el ejecutable.");
            }
            return (AppConfigObj)GenericYmlMapper.super.loadYmlFile(file);
      }

      private boolean validConfigFile(Path filePath)
      {
            return filePath.endsWith(SUFFIX_CONFIG_YML) && Files.exists(filePath);
      }

}
