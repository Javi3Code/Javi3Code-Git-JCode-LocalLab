package org.jeycode.localab.config;

import javax.validation.Validation;
import javax.validation.Validator;

import org.jeycode.localab.applicationcontext.model.ApplicationContext;
import org.jeycode.localab.applicationcontext.service.ApplicationContextLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class GenericUtilsConfig
{

      private final ApplicationContextLoader applicationContextLoaderImpl;
      
      @Bean
      public Validator getDefaultValidator()
      {
            return Validation.buildDefaultValidatorFactory()
                             .getValidator();
      }

      @Bean @Scope(value = "singleton")
      public ApplicationContext jclabloApplicationContextObj()
      {
            return applicationContextLoaderImpl.getApplicationContextObj();
      }

}
