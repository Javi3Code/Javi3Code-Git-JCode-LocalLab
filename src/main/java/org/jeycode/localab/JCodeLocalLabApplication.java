package org.jeycode.localab;

import java.io.File;

import org.jeycode.localab.loader.ConcreteTaskYmlMapper;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.mapper.ConcreteTaskMapper;
import org.jeycode.localab.taskmodel.repository.ConcreteTaskRepository;
import org.jeycode.localab.ymlobjtemplates.YmlObjTemplates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class JCodeLocalLabApplication
{

      private final YmlObjTemplates templates;
      private final ConcreteTaskRepository repo;
      private final ConcreteTaskMapper mapp;

      public static void main(String[] args)
      {
            SpringApplication.run(JCodeLocalLabApplication.class,args);

      }

//       Ejemplo para serializar o deserializar los yml usados en la app
      @Bean
      public CommandLineRunner commandLineRunner(@Autowired JCodeLocalLabApplication app)
      {
            return args->
                  {

                        Thread.sleep(2000);
//                        app.templates.exportAppConfigYmlTemplate();
                        app.templates.exportConcreteTaskYmlTemplate();
                        ConcreteTaskYmlMapper mapper = new ConcreteTaskYmlMapper();
                        ConcreteTaskDto concTask = mapper.loadYmlFile(new File("concretetasksample.yml"));
//                        System.out.println(concTask);
//                        log.info("Guardado: " + repo.save(mapp.reverse(concTask)));
//                        log.info("Obtenido: " + repo.findById(concTask.getTaskname()));

                        repo.findAll()
                            .forEach(System.out::println);

                  };
      }

}
