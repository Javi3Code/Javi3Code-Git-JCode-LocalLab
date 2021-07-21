package org.jeycode.localab;

import java.io.File;
import java.io.IOException;

import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.loader.ConfigMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class JCodeLocalLabApplication
{

      private static final File configFile = new File("config.yml");
      final ConfigMapper configMapper;

      public static void main(String[] args) throws JsonParseException,JsonMappingException,IOException
      {
            SpringApplication.run(JCodeLocalLabApplication.class,args);

            ConfigMapper configMapper = new ConfigMapper();
            AppConfigObj config = configMapper.loadYmlFile(configFile);
            System.out.println(config);

            configMapper.writeYmlFile(new File("ymlsample.yml"),new AppConfigObj());
      }

}
