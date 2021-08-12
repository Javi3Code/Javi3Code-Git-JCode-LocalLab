package org.jeycode.localab.commandmodel.validator;

public interface CommandOrParameterValidator
{
      boolean validateCommand(String command);

       boolean validateParameter(String parameter);
}
