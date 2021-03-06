package org.jeycode.localab.taskmodel.err;

import static org.jeycode.localab.utils.GenericHelper.dateTimeFormattedToString;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Getter
@Setter
@AllArgsConstructor
public class TaskModelException extends RuntimeException
{

      private static final long serialVersionUID = 1L;

      private String reason,solution;
      private final String date = dateTimeFormattedToString();

}
