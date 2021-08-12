package org.jeycode.localab.commandmodel.validator;

import static org.jeycode.localab.utils.GenericHelper.PARAMETER_INDICATOR;

import org.jeycode.localab.commandmodel.manager.CommandManager;
import org.jeycode.localab.taskmodel.err.CommandException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
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
                  throw new CommandException(command + " --> No es un comando válido");
            }
            actualValidCommand = command;
            return true;
      }

      @Override
      public boolean validateParameter(String parameter)
      {
            if (parameter.charAt(0) != PARAMETER_INDICATOR)
            {
                  throw new CommandException(parameter
                                          + " debe ir precedido por -, el formato válido es {command -parameter1 -parameter2}");
            }
            if (!commandManager.getAllParametersOfThisCommand(actualValidCommand)
                               .contains(parameter))
            {
                  throw new CommandException(parameter + " no es un parámetro válido para el commando " + actualValidCommand
                                          + "\nPuedes ver los parámetros adecuados introduciendo {command -h}"
                                          + "o ver toda la info de comandos con el comando {help}");
            }
            return true;
      }

}
