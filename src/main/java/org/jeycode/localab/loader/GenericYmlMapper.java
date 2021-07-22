package org.jeycode.localab.loader;

import java.io.File;
import java.io.IOException;

import org.jeycode.localab.taskmodel.model.YMLObj;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/**
 * 
 * Interface que define un único método a implementar por sus clases hijas y dos
 * métodos default que ya ofrecen la funcionalidad necesaria para el mapeo.
 * 
 * 
 * @see ConcreteTaskYmlMapper
 * @see ConfigYmlMapper
 * 
 * @author Javier Pérez Alonso
 *
 *         21 jul. 2021
 *
 */

public interface GenericYmlMapper
{

      String CONFIGMAPPER = "configmapper";
      String CONCRETETASKFILEMAPPER = "concretetaskfilemapper";

      ObjectMapper objMapper = new ObjectMapper(new YAMLFactory());

      /**
       * 
       * Method getClassObjToReturn : Único método a implementar en las clases que
       * implementan GenericFileMapper.
       *
       * @return la clase del objeto a mapear el fichero YML
       */
      Class<? extends YMLObj> getClassObjToReturn();

      /**
       * 
       * Method loadYmlFile
       *
       * @param file : fichero a mapear.
       * @return un {@link YMLObj} específico mapeado con los valores del fichero
       *         file.
       * @throws JsonParseException
       * @throws JsonMappingException
       * @throws IOException
       */
      default YMLObj loadYmlFile(File file) throws JsonParseException,JsonMappingException,IOException
      {
            return objMapper.readValue(file,getClassObjToReturn());
      }

      /**
       * 
       * Method writeYmlFile
       *
       * @param file
       * @param obj
       * @throws JsonGenerationException
       * @throws JsonMappingException
       * @throws IOException
       */
      default void writeYmlFile(File file,Object obj) throws JsonGenerationException,JsonMappingException,IOException
      {
            objMapper.writerWithDefaultPrettyPrinter()
                     .writeValue(file,obj);
      }
}
