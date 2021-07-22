package org.jeycode.localab.loader;

import static org.jeycode.localab.loader.GenericYmlMapper.CONCRETETASKFILEMAPPER;

import java.io.File;
import java.io.IOException;

import org.jeycode.localab.taskmodel.model.TaskFiles;
import org.jeycode.localab.taskmodel.model.YMLObj;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

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

@RequiredArgsConstructor
@Component(CONCRETETASKFILEMAPPER)
public class ConcreteTaskYmlMapper implements GenericYmlMapper
{

      @Override
      public Class<? extends YMLObj> getClassObjToReturn()
      {
            return ConcreteTaskDto.class;
      }

      @Override
      public ConcreteTaskDto loadYmlFile(File file) throws JsonParseException,JsonMappingException,IOException
      {
            return (ConcreteTaskDto)GenericYmlMapper.super.loadYmlFile(file);
      }
}
