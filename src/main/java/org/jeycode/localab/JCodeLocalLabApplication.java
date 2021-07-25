package org.jeycode.localab;

import java.io.File;

import org.jeycode.localab.loader.ConcreteTaskYmlMapper;
import org.jeycode.localab.taskmodel.controller.ConcreteTaskController;
import org.jeycode.localab.taskmodel.err.TaskFieldsException;
import org.jeycode.localab.taskmodel.err.TaskModelException;
import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.mapper.ConcreteTaskMapper;
import org.jeycode.localab.taskmodel.repository.ConcreteTaskRepository;
import org.jeycode.localab.taskmodel.service.ConcreteTaskAccessService;
import org.jeycode.localab.ymlobjtemplates.YmlObjTemplates;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RequiredArgsConstructor
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class JCodeLocalLabApplication implements CommandLineRunner
{

      private final YmlObjTemplates templates;
      private final ConcreteTaskRepository repo;
      private final ConcreteTaskAccessService service;
      private final ConcreteTaskController controller;
      private final ConcreteTaskMapper mapp;

      public static void main(String[] args)
      {
            SpringApplication.run(JCodeLocalLabApplication.class,args);

      }

      @Override
      public void run(String...args) throws Exception
      {

//          templates.exportAppConfigYmlTemplate();
//            templates.exportConcreteTaskYmlTemplate();
            ConcreteTaskYmlMapper mapper = new ConcreteTaskYmlMapper();
            ConcreteTaskDto concTask;
            concTask = mapper.loadYmlFile(new File("concretetasksample.yml"));// System.out.println(concTask);
            showData(concTask);
      }

      private void showData(ConcreteTaskDto concTask)
      {
            ConcreteTask concEntity = mapp.reverse(concTask);
            try
            {

                  controller.addOne(concTask);

                  log.info("Actualmente: " + service.findAll());
            }
            catch (TaskFieldsException ex)
            {

                  log.error(ex.getDate() + " --- " + ex.getValidateErrMessages());
            }
            catch (TaskModelException ex)
            {
                  log.error(ex.getDate() + " --- " + ex.getReason() + " --- " + ex.getSolution());
            }
            log.info("Guardado: " + repo.save(concEntity));
      }

}
