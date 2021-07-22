package org.jeycode.localab.ymlobjtemplates;

import java.io.File;
import java.io.IOException;

import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.loader.GenericYmlMapper;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class YmlObjTemplates
{

//      @Qualifier(CONFIGMAPPER)
//      @Autowired //No uso esto por @Primary en ConfigMapper
      private final GenericYmlMapper mapper;
      private final AppConfigObj appConfigObj;
      private final ConcreteTaskDto concreteTaskObj;

      public void exportAppConfigYmlTemplate() throws JsonGenerationException,JsonMappingException,IOException
      {
            mapper.writeYmlFile(new File("configSample.yml"),appConfigObj);

      }

      public void exportConcreteTaskYmlTemplate() throws JsonGenerationException,JsonMappingException,IOException
      {
            mapper.writeYmlFile(new File("concretetasksample.yml"),concreteTaskObj);
      }

}
