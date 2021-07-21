package org.jeycode.localab.loader;

import static org.jeycode.localab.loader.GenericFileMapper.CONFIGMAPPER;

import java.io.File;
import java.io.IOException;

import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.wrappermodel.YMLObj;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Clase para cargar YML de configuración de la aplicación. Implementa
 * {@link GenericFileMapper} Establece la clase a mapear.
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
@Primary
public class ConfigMapper implements GenericFileMapper
{

      @Override
      public Class<? extends YMLObj> getClassObjToReturn()
      {
            return AppConfigObj.class;
      }

      @Override
      public AppConfigObj loadYmlFile(File file) throws JsonParseException,JsonMappingException,IOException
      {
            return (AppConfigObj)GenericFileMapper.super.loadYmlFile(file);
      }

}
