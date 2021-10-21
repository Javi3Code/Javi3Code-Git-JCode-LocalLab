package org.jeycode.localab.utils.ymltemplate;

import static org.jeycode.localab.loader.GenericYmlMapper.writeYmlFile;

import java.io.File;
import java.io.IOException;

import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

@Component("ymlObjectTemplates")
@RequiredArgsConstructor
public class YmlObjTemplates
{

      private final AppConfigObj appConfigObjTemplate;
      private final ConcreteTaskDto concreteTaskObj;

      public void exportAppConfigYmlTemplate() throws JsonGenerationException,JsonMappingException,IOException
      {
            writeYmlFile(new File("config.yml"),appConfigObjTemplate);

      }

      public void exportConcreteTaskYmlTemplate() throws JsonGenerationException,JsonMappingException,IOException
      {
            writeYmlFile(new File("concretetasksample.yml"),concreteTaskObj);
      }

}
