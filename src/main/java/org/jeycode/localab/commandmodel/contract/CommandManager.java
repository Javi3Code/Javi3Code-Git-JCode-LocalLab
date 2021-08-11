package org.jeycode.localab.commandmodel.contract;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 
 * Contrato a firmar por un Command Manager.
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         11 ago. 2021
 *
 */
public interface CommandManager
{
      
//      Map<CommandWrapper> commandWrapperLst();

      Set<String> getAllCommands();

      Set<String> getAllParametersOfThisCommand();

      default String getcommandIfIsUniqueThatStartWith(String startCommand)
      {
            Stream<String> streamOfCommands = getAllCommands().stream();
            Stream<String> commandValid = streamOfCommands.filter(command-> command.startsWith(startCommand));
            long coincidence = commandValid.count();

            if (coincidence == 1)
            {
                  return commandValid.findFirst()
                                     .get();
            }
            return startCommand;
      }

      Map<String,String> getCommandsInfo();

      default String getCommandInfo(String command)
      {
            return getCommandsInfo().get(command);
      }

}
