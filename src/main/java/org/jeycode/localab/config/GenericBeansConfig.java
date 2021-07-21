package org.jeycode.localab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@Configuration
public class GenericBeansConfig
{

      @Bean @Scope("singleton")
      public ObjectMapper objectMapper()
      {
            return new ObjectMapper(new YAMLFactory());
      }

}
