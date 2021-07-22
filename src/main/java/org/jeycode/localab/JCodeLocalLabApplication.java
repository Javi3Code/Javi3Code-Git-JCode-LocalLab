package org.jeycode.localab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class JCodeLocalLabApplication
{

//      private final YmlObjTemplates templates; 

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
//                        app.templates.exportAppConfigYmlTemplate();
//                        app.templates.exportConcreteTaskYmlTemplate();
//                        ConcreteTaskYmlMapper mapper = new ConcreteTaskYmlMapper();
//                        System.out.println(mapper.loadYmlFile(new File("concretetasksample.yml")));
                  };
      }

}
