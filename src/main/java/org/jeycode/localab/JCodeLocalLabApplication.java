package org.jeycode.localab;

import java.io.File;
import java.io.IOException;

import org.jeycode.localab.config.ConfigMapper;
import org.jeycode.localab.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
public class JCodeLocalLabApplication
{

      private static final File configFile = new File("config.yml");

      public static void main(String[] args) throws JsonParseException,JsonMappingException,IOException
      {
            SpringApplication.run(JCodeLocalLabApplication.class,args);

            ConfigMapper configMapper = new ConfigMapper();
            Configuration config = configMapper.loadConfiguration(configFile);
            System.out.println(config);

            configMapper.writeYMLConfig(new File("ymlsample.yml"),new Configuration());
      }

}
