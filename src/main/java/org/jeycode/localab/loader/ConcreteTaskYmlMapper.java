package org.jeycode.localab.loader;

import java.io.IOException;

import org.jeycode.localab.taskmodel.model.TaskFiles;
import org.jeycode.localab.taskmodel.model.YMLObj;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 
 * * Clase para cargar YML de cierta tarea. Implementa {@link GenericYmlMapper}
 * Establece la clase a mapear.
 * 
 * @see TaskFiles
 * 
 * @author Javier Pérez Alonso
 *
 *         21 jul. 2021
 *
 */

public class ConcreteTaskYmlMapper implements GenericYmlMapper
{

      @Override
      public Class<? extends YMLObj> getClassObjToReturn()
      {
            return ConcreteTaskDto.class;
      }

      @Override
      public ConcreteTaskDto loadYmlFile(String file) throws JsonParseException,JsonMappingException,IOException
      {
            return (ConcreteTaskDto)GenericYmlMapper.super.loadYmlFile(file);
      }
}
