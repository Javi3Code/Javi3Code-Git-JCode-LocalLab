package org.jeycode.localab;

import java.io.File;

import org.jeycode.localab.loader.ConcreteTaskYmlMapper;
import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.mapper.ConcreteTaskMapper;
import org.jeycode.localab.taskmodel.repository.ConcreteTaskRepository;
import org.jeycode.localab.taskmodel.repository.TaskFilesRepository;
import org.jeycode.localab.ymlobjtemplates.YmlObjTemplates;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class JCodeLocalLabApplication implements CommandLineRunner
{

      private final YmlObjTemplates templates;
      private final ConcreteTaskRepository repo;
      private final TaskFilesRepository taskFilesRepos;
      private final ConcreteTaskMapper mapp;

      public static void main(String[] args)
      {
            SpringApplication.run(JCodeLocalLabApplication.class,args);

      }

      @Override
      public void run(String...args) throws Exception
      {

//          templates.exportAppConfigYmlTemplate();
            templates.exportConcreteTaskYmlTemplate();
            ConcreteTaskYmlMapper mapper = new ConcreteTaskYmlMapper();
            ConcreteTaskDto concTask;
            concTask = mapper.loadYmlFile(new File("concretetasksample.yml"));// System.out.println(concTask);
            ConcreteTask concEntity = mapp.reverse(concTask);
//            log.info(concEntity.getTaskFiles()
//                               .toString());
            log.info("Guardado: " + repo.save(concEntity));
//            log.info("Obtenido: " + repo.findById(concTask.getTaskname()));
//            log.info(taskFilesRepos.save(TaskFiles.builder()
//                                                  .css(List.of(CssFile.builder()
//                                                                      .build()))
//                                                  .build())
//                                    + "");

      }

}
