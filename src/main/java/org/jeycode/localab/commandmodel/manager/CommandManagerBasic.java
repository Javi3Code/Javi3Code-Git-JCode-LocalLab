package org.jeycode.localab.commandmodel.manager;

import static org.jeycode.localab.commandmodel.helper.Commands.CLOSE;
import static org.jeycode.localab.commandmodel.helper.Executables.closeApp;
import static org.jeycode.localab.utils.GenericHelper.ASYNC_EXECUTOR;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jeycode.localab.commandmodel.CommandWrapper;
import org.jeycode.localab.view.component.AppPrincipalWindow;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@Scope("singleton")
@RequiredArgsConstructor
public class CommandManagerBasic implements CommandManager
{

      private final AppPrincipalWindow appPrincipalWindow;

      private final Map<String,CommandWrapper> commandWrapperMap = new HashMap<>();

      public void init()
      {
            loadCommandWrapperMap();
      }

      @Override
      public Map<String,CommandWrapper> commandWrapperMap()
      {
            return commandWrapperMap;
      }

      @Override
      public Set<String> getAllCommands()
      {
            return commandWrapperMap.keySet();
      }

      @Override
      public Set<String> getAllParametersOfThisCommand(String command)
      {
            return commandWrapperMap.get(command)
                                    .getParameters();
      }

      @Async(ASYNC_EXECUTOR)
      private void loadCommandWrapperMap()
      {
            CommandWrapper close = CommandWrapper.builder()
                                                 .executable(closeApp(appPrincipalWindow))
                                                 .build();
            commandWrapperMap.put(CLOSE,close);

            CommandWrapper sleep = CommandWrapper.builder()
                                                 .build();

      } 

}
