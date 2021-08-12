package org.jeycode.localab.commandmodel.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jeycode.localab.commandmodel.CommandWrapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CommandManagerBasic implements CommandManager
{

      private final Map<String,CommandWrapper> commandWrapperMap = new HashMap<>();

      public CommandManagerBasic()
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
            return null;
      }

      @Override
      public Set<String> getAllParametersOfThisCommand(String command)
      {
            return null;
      }

      @Override
      public Map<String,String> getCommandsInfo()
      {
            return null;
      }

      private void loadCommandWrapperMap()
      {}

}