package org.jeycode.localab;

import java.awt.Container;
import java.awt.Toolkit;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jeycode.localab.applicationcontext.model.ApplicationContext;
import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.filesworker.FileWorker;
import org.jeycode.localab.loader.ConcreteTaskYmlMapper;
import org.jeycode.localab.taskmodel.controller.ConcreteTaskController;
import org.jeycode.localab.taskmodel.err.TaskFieldsException;
import org.jeycode.localab.taskmodel.err.TaskModelException;
import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.mapper.ConcreteTaskMapper;
import org.jeycode.localab.taskmodel.repository.ConcreteTaskRepository;
import org.jeycode.localab.taskmodel.service.ConcreteTaskAccessService;
import org.jeycode.localab.utils.ymltemplate.YmlObjTemplates;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RequiredArgsConstructor
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class JCodeLocalLabApplication implements CommandLineRunner
{

      private final YmlObjTemplates templates;
      private final List<Class<?>> themes;
      private final AppConfigObj configObj;
      private final ApplicationContext applicationContext;
      private final ConcreteTaskRepository repo;
      private final ConcreteTaskAccessService service;
      private final ConcreteTaskController controller;
      private final ConcreteTaskMapper mapp;
      private final ThreadPoolTaskExecutor executor;
      private final FileWorker fileWorker;
   

      private static int index = 0;

      public static void main(String[] args)
      {
            new SpringApplicationBuilder(JCodeLocalLabApplication.class).headless(false)
                                                                        .run(args);
            FlatGitHubDarkIJTheme.setup();
            JFrame frame = new JFrame();
            frame.setSize(Toolkit.getDefaultToolkit()
                                 .getScreenSize());
            JButton btn = new JButton("push");
            btn.addActionListener(ev->
                  {
                        Class<?> forName;
                        try
                        {
                              forName = Class.forName(Arrays.asList(FlatAllIJThemes.INFOS)
                                                            .get(index)
                                                            .getClassName());
                              forName.getMethod("setup",null)
                                     .invoke(null,null);
                              SwingUtilities.updateComponentTreeUI(frame);
                              index++;
                        }
                        catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException |
                              NoSuchMethodException | SecurityException ex)
                        {
                              ex.printStackTrace();
                        }

                  });
            JTextArea area = new JTextArea("asdadadadsda");

            btn.setSize(200,100);
            btn.setLocation(200,200);
            Container contentPane = frame.getContentPane();
            contentPane.setLayout(null);
            frame.setVisible(true);
            contentPane.add(btn);
            area.setBorder(BorderFactory.createEtchedBorder());
            area.setBounds(300,350,1000,1000);
            contentPane.add(area);

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      }

      @Override
      public void run(String...args) throws Exception
      {
            themes.forEach(System.out::println);
            System.out.println(configObj);
            System.out.println(applicationContext);
//            ymlTemplateProof();
//            executorCopyFileProof();

//            worker.createTaskModelStructure(Paths.get("C:\\Users\\JAVIER\\Desktop\\simple"),false);
//            worker.createTaskModelStructure(Paths.get("C:\\Users\\JAVIER\\Desktop\\complex"),true);
//            executor.destroy();

      }

      private void ymlTemplateProof() throws JsonGenerationException,JsonMappingException,IOException,JsonParseException
      {
            templates.exportAppConfigYmlTemplate();
            templates.exportConcreteTaskYmlTemplate();
            ConcreteTaskYmlMapper mapper = new ConcreteTaskYmlMapper();
            ConcreteTaskDto concTask;
            concTask = mapper.loadYmlFile("concretetasksample.yml");// System.out.println(concTask);
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
                                 executor.submit(()-> fileWorker.copyFile(source,target));
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
