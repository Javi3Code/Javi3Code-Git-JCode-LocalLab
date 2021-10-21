package org.jeycode.localab.config;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.jeycode.localab.utils.GenericHelper.CONCRETETASKFILE_MAPPER;
import static org.jeycode.localab.utils.GenericHelper.CONFIG_MAPPER;

import java.io.IOException;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;

import org.jeycode.localab.applicationcontext.model.ApplicationContext;
import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.loader.ConcreteTaskYmlMapper;
import org.jeycode.localab.loader.ConfigYmlMapper;
import org.jeycode.localab.utils.GenericHelper;
import org.jeycode.localab.utils.ymltemplate.YmlObjTemplates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class GenericUtilsConfig
{

      private final YmlObjTemplates ymlObjectTemplates;

      @Bean
      public Validator getDefaultValidator()
      {
            return Validation.buildDefaultValidatorFactory()
                             .getValidator();
      }

      @Bean(CONFIG_MAPPER) @Scope("singleton") @Order(Ordered.HIGHEST_PRECEDENCE)
      public ConfigYmlMapper configYmlMapper()
      {
            return new ConfigYmlMapper();
      }

      @Bean(CONCRETETASKFILE_MAPPER) @Scope("singleton")
      public ConcreteTaskYmlMapper concreteTaskYmlMapper()
      {
            return new ConcreteTaskYmlMapper();
      }

      // @formatter:off
      @Bean(name = "themes") @Scope("singleton")
      public List<Class<?>> themes()
      {
            return stream(FlatAllIJThemes.INFOS).map(theme->
                  {
                        try
                        {
                              return Class.forName(theme.getClassName());
                        }
                        catch (ClassNotFoundException ex)
                        {
                              return null;
                        }
                  }).collect(toList());
      } 
   // @formatter:on

      @Bean(name = "configObj") @Scope(value = "singleton")
      public AppConfigObj configObj() throws Exception
      {
            try
            {
                  ConfigYmlMapper configYmlMapper = configYmlMapper();
                  return configYmlMapper.loadYmlFile(GenericHelper.CONFIG_YML);
            }
            catch (IOException ex)
            {
                  log.error(ex.getMessage(),ex);
                  ymlObjectTemplates.exportAppConfigYmlTemplate();
                  throw new Exception();
            }
      }

      @Bean(name = "applicationContext") @Scope(value = "singleton")
      public ApplicationContext jclabloApplicationContextObj() throws Exception
      {
            AppConfigObj configObj = configObj();
            return ApplicationContext.builder()
                                     .activeWorkspace(configObj.getWorkspaces()
                                                               .get(configObj.getWorkspace()))
                                     .activeOrigin(configObj.getOrigins()
                                                            .get(configObj.getOrigin()))
                                     .activeFlatTheme(configObj.getTheme())
                                     .build();
      }

}
