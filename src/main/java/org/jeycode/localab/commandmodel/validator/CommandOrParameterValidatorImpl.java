package org.jeycode.localab.commandmodel.validator;

import static org.jeycode.localab.utils.GenericHelper.PARAMETER_INDICATOR;

import org.jeycode.localab.commandmodel.manager.CommandManager;
import org.jeycode.localab.taskmodel.err.CommandException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandOrParameterValidatorImpl implements CommandOrParameterValidator
{

      private final CommandManager commandManager;
      private String actualValidCommand;

      @Override
      public boolean validateCommand(String command)
      {
            if (!commandManager.getAllCommands()
                               .contains(command))
            {
                  throw new CommandException(String.format("[%s] --> No es un comando válido",command));
            }
            actualValidCommand = command;
            log.info(String.format("Se ha validado el comando [%s]",command));
            return true;
      }

      @Override
      public boolean validateParameter(String parameter)
      {
            if (parameter.charAt(0) != PARAMETER_INDICATOR)
            {
                  throw new CommandException(String.format("[%s] --> debe ir precedido por -, el formato válido es {command -parameter1 -parameter2}",
                                                           parameter));
            }
            if (!commandManager.getAllParametersOfThisCommand(actualValidCommand)
                               .contains(parameter))
            {
                  throw new CommandException(String.format("[%s] --> no es un parámetro válido para el commando %s\nPuedes ver los parámetros adecuados introduciendo {command -h} o ver toda la info de comandos con el comando {help}",
                                                           parameter,actualValidCommand));
            }
            log.info(String.format("Se ha validado el parámetro [%s]",parameter));
            return true;
      }

}
