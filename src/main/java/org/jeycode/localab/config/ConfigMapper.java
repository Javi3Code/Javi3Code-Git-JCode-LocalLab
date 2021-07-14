package org.jeycode.localab.config;

import java.io.File;
import java.io.IOException;

import org.jeycode.localab.utils.YMLMapperHelper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ConfigMapper implements YMLMapperHelper
{

      public Configuration loadConfiguration(File configFile) throws JsonParseException,JsonMappingException,IOException
      {
            return (Configuration)readYML(configFile,Configuration.class);
      }

      public void writeYMLConfig(File file,Object obj) throws JsonGenerationException,JsonMappingException,IOException
      {
            writeYML(file,obj);
      }

}
