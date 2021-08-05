package org.jeycode.localab.config;

import javax.validation.Validation;
import javax.validation.Validator;

import org.jeycode.localab.utils.files.LabFilesHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GenericUtilsConfig
{

      @Bean
      public Validator getDefaultValidator()
      {
            return Validation.buildDefaultValidatorFactory()
                             .getValidator();
      }

      @Bean(initMethod = "loadEnumMapValues") @Scope(value = "singleton")
      public LabFilesHelper getFilesHelper()
      {
            return new LabFilesHelper();
      }

}
