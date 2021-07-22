package org.jeycode.localab.taskmodel.err;

import static org.jeycode.localab.utils.GenericHelper.dateFormatted;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskModelException extends RuntimeException
{

      private static final long serialVersionUID = 1L;

      private String reason;
      private String date = dateFormatted();

}
