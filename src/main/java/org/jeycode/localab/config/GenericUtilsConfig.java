package org.jeycode.localab.config;

import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericUtilsConfig
{

      @Bean
      public Validator getDefaultValidator()
      {
            return Validation.buildDefaultValidatorFactory()
                             .getValidator();
      }
}
