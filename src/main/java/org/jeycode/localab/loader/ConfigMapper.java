package org.jeycode.localab.loader;

import static org.jeycode.localab.loader.GenericFileMapper.CONFIGMAPPER;

import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.utils.YMLObj;
import org.springframework.stereotype.Component;

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
public class ConfigMapper implements GenericFileMapper
{

      @Override
      public Class<? extends YMLObj> getClassObjToReturn()
      {
            return AppConfigObj.class;
      }

}
