package org.jeycode.localab;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.jeycode.localab.commandmodel.manager.CommandManager;
import org.jeycode.localab.commandmodel.validator.CommandOrParameterValidator;
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
import org.jeycode.localab.utils.ymltemplate.YmlObjTemplates;
import org.jeycode.localab.view.component.AppPrincipalWindow;
import org.jeycode.localab.view.component.VisualInfoArea;
import org.jeycode.localab.view.component.panel.CommandMenuPanel;
import org.jeycode.localab.view.component.panel.PrincipalPanel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
      private final ConcreteTaskRepository repo;
      private final ConcreteTaskAccessService service;
      private final ConcreteTaskController controller;
      private final ConcreteTaskMapper mapp;
      private final ThreadPoolTaskExecutor executor;
      private final CommandOrParameterValidator validator;
      private final CommandManager manager;
      private final AppPrincipalWindow window;

      private static int index = 0;

      public static void main(String[] args)
      {
            new SpringApplicationBuilder(JCodeLocalLabApplication.class).headless(false)
                                                                        .run(args);
            FlatGitHubDarkIJTheme.setup();
            new AppPrincipalWindow(new PrincipalPanel(new VisualInfoArea(),new CommandMenuPanel())).start();
//
//            JFrame frame = new JFrame();
//            frame.setSize(Toolkit.getDefaultToolkit()
//                                 .getScreenSize());
//            JButton btn = new JButton("push");
//            JCheckBox check = new JCheckBox("asadasd");
//            check.setBounds(300,300,1000,1000);
//            JCLaboComponentSlideEvent slideEvent = new JCLaboComponentSlideEvent(check,SlideEvent.POSITION_OPEN,JC_Axis.X_AXIS,2000,1,1,null);
//            btn.addActionListener(ev->
//                  {
//                        if (slideEvent.isRunning())
//                        {
//                              System.out.println("Cambiamos de dirección");
//                              slideEvent.changeSlideDirection();
//                        }
//                        else
//                        {
//                              slideEvent.start();
//                        }
//                        Class<?> forName;
//                        try
//                        {
//                              forName = Class.forName(Arrays.asList(FlatAllIJThemes.INFOS)
//                                                            .get(index)
//                                                            .getClassName());
//                              forName.getMethod("setup",null)
//                                     .invoke(null,null);
//                              SwingUtilities.updateComponentTreeUI(frame);
//                              index++;
//                        }
//                        catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException |
//                              NoSuchMethodException | SecurityException ex)
//                        {
//                              ex.printStackTrace();
//                        }

//                  });
//            JEditorPane editor= new JEditorPane();
//            JTextArea area=new JTextArea("asdadadadsda");
//            editor.setBorder(new BevelBorder(BevelBorder.RAISED));
//            editor.setBackground(Color.gray);

//            btn.setSize(200,100);
//            btn.setLocation(200,200);
//
//            Container contentPane = frame.getContentPane();
//            contentPane.setLayout(null);
//            contentPane.add(btn);
//            contentPane.add(check);
//            frame.setVisible(true);
//
//            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      }

      @Override
      public void run(String...args) throws Exception
      {
//            ymlTemplateProof();
//            executorCopyFileProof();

//            worker.createTaskModelStructure(Paths.get("C:\\Users\\JAVIER\\Desktop\\simple"),false);
//            worker.createTaskModelStructure(Paths.get("C:\\Users\\JAVIER\\Desktop\\complex"),true);
//            executor.destroy();
//            validator.validateCommand("push");
//            validator.validateCommand("asdad");
//            manager.getCommandInfo("bye")
//                   .forEach(System.out::println);
//            manager.commandWrapperMap()
//                   .get("bye")
//                   .getExecutable()
//                   .execute(null,null);

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
                                 executor.submit(()-> LabFileWorker.copyFile(source,target));
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
