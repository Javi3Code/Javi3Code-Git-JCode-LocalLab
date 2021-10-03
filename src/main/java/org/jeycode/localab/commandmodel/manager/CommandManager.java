package org.jeycode.localab.commandmodel.manager;

import static org.jeycode.localab.utils.GenericHelper.PARAMETER_INDICATOR;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.jeycode.localab.commandmodel.CommandWrapper;

/**
 * 
 * Contrato a firmar por un Command Manager, dejamos a la implementación definir
 * la lista de comandos/parámetros/descripción.
 * 
 * @see CommandWrapper
 * @see CommandManagerBasic
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         11 ago. 2021
 *
 */
public interface CommandManager
{

      Map<String,CommandWrapper> commandWrapperMap();

      Set<String> getAllCommands();

      Set<String> getAllParametersOfThisCommand(String command);

      default String getcommandIfIsUniqueThatStartWith(String startCommand)
      {
            Stream<String> streamOfCommands = getAllCommands().stream();
            return getIfIsUniqueThatStartWith(startCommand,streamOfCommands);
      }

      default String getParameterOfThisCommandIfIsUniqueThatStartWith(String command,String startParameter)
      {
            Stream<String> streamOfParameter = getAllParametersOfThisCommand(extractParameter(command)).stream();
            return getIfIsUniqueThatStartWith(startParameter,streamOfParameter);
      }

      default String extractParameter(String command)
      {
            return command.replace(PARAMETER_INDICATOR,'\0');
      }

      default String getIfIsUniqueThatStartWith(String start,Stream<String> stream)
      {
            Stream<String> elementValid = stream.filter(element-> element.startsWith(start));
            long coincidence = elementValid.count();

            if (coincidence == 1)
            {
                  return elementValid.findFirst()
                                     .get();
            }
            return start;
      }

      default Stream<String> getCommandInfo(String command)
      {
            try
            {
                  return Files.lines(Paths.get(String.format("src/main/resources/commands-info/%s.txt",command)));
            }
            catch (IOException ex)
            {}
            return null;
      }

}
