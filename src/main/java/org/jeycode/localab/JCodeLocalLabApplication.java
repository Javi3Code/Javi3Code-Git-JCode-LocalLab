package org.jeycode.localab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.jeycode.localab.filesworker.LabFileWorker;
import org.jeycode.localab.loader.ConcreteTaskYmlMapper;
import org.jeycode.localab.taskmodel.controller.ConcreteTaskController;
import org.jeycode.localab.taskmodel.err.TaskFieldsException;
import org.jeycode.localab.taskmodel.err.TaskModelException;
import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.mapper.ConcreteTaskMapper;
import org.jeycode.localab.taskmodel.repository.ConcreteTaskRepository;
import org.jeycode.localab.taskmodel.service.ConcreteTaskAccessService;
import org.jeycode.localab.utils.files.LabFilesHelper;
import org.jeycode.localab.utils.ymltemplate.YmlObjTemplates;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

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
      private final LabFilesHelper filesHelper;
      private final LabFileWorker worker;
      private final ThreadPoolTaskExecutor executor;

      public static void main(String[] args)
      {
            SpringApplication.run(JCodeLocalLabApplication.class,args);

      }

      @Override
      public void run(String...args) throws Exception
      {

//            ymlTemplateProof();
//            executorCopyFileProof();

            worker.createTaskModelStructure(Paths.get("C:\\Users\\JAVIER\\Desktop\\simple"),false);
            worker.createTaskModelStructure(Paths.get("C:\\Users\\JAVIER\\Desktop\\complex"),true);
            executor.destroy();

      }

      private void ymlTemplateProof() throws JsonGenerationException,JsonMappingException,IOException,JsonParseException
      {
            templates.exportAppConfigYmlTemplate();
            templates.exportConcreteTaskYmlTemplate();
            ConcreteTaskYmlMapper mapper = new ConcreteTaskYmlMapper();
            ConcreteTaskDto concTask;
            concTask = mapper.loadYmlFile(new File("concretetasksample.yml"));// System.out.println(concTask);
            showData(concTask);
      }

      private void executorCopyFileProof()
      {
            List<Path> paths = Arrays.asList(Paths.get("C:\\Users\\JAVIER\\Desktop\\Databases\\MySql_DATABASE\\Personas.sql"),
                                             Paths.get("C:\\Users\\JAVIER\\Desktop\\Databases\\sqlite\\fistsqlitedb"),
                                             Paths.get("C:\\\\Users\\\\JAVIER\\\\Desktop\\\\Databases\\\\sqlite\\\\fistsqlitedb.db"));

            IntStream.range(0,3)
                     .forEach(num->
                           {
                                 Path source = paths.get(num);
                                 Path target = Paths.get("C:\\Users\\JAVIER\\Desktop\\adasd\\")
                                                    .resolve(source.getFileName());
                                 executor.submit(()-> worker.copyFile(source,target));
                           });
            executor.destroy();
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
