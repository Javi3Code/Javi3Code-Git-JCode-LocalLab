package org.jeycode.localab.loader;

import static org.jeycode.localab.loader.GenericFileMapper.CONCRETETASKFILEMAPPER;

import java.io.File;
import java.io.IOException;

import org.jeycode.localab.wrappermodel.TaskFiles;
import org.jeycode.localab.wrappermodel.YMLObj;
import org.jeycode.localab.wrappermodel.dto.ConcreteTaskDto;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

/**
 * 
 * * Clase para cargar YML de cierta tarea. Implementa {@link GenericFileMapper}
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
public class ConcreteTaskFileMapper implements GenericFileMapper
{

      @Override
      public Class<? extends YMLObj> getClassObjToReturn()
      {
            return ConcreteTaskDto.class;
      }

      @Override
      public ConcreteTaskDto loadYmlFile(File file) throws JsonParseException,JsonMappingException,IOException
      {
            return (ConcreteTaskDto)GenericFileMapper.super.loadYmlFile(file);
      }
}
