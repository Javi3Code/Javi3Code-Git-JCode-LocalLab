package org.jeycode.localab.taskmodel.err;

import static org.jeycode.localab.utils.GenericHelper.dateTimeFormattedToString;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskFieldsException extends RuntimeException
{

      private String validateErrMessages;
      private final String date = dateTimeFormattedToString();
      /**
       * 
       */
      private static final long serialVersionUID = 1L;

}
