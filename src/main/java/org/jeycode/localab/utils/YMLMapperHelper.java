package org.jeycode.localab.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public interface YMLMapperHelper
{

      ObjectMapper configMapper = new ObjectMapper(new YAMLFactory());

      default Object readYML(File file,Class<?> ymlClass) throws JsonParseException,JsonMappingException,IOException
      {
            return configMapper.readValue(file,ymlClass);
      }

      default void writeYML(File file,Object obj) throws JsonGenerationException,JsonMappingException,IOException
      {
            configMapper.writerWithDefaultPrettyPrinter()
                        .writeValue(file,obj);
      }
}
