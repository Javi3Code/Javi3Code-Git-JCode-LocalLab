package org.jeycode.localab.utils;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;

public interface GenericHelper
{

      /**
       * Constants
       */
      String EMPTY_STRING = "";
      String Generic_SLASH = File.separator;
      String Rigth_SLASH = "/";
      String Left_SALSH = "\\";

      /*
       * Dir Task Model Structure
       */
      String PARENT_TASKFILES_DIR = "Work_Files";
      String ORIGIN_BACKUP = "origin_backup";
      String TASK_BACKUP = "task_backup";
// Hasta aquí mismo nivel detro del dir de la tarea
      String RESOURCES = "resources";
//Hasta aquí las carpetas para cada recurso - Las que no vemos aquí son las del Enum -> FileExtension
//Dentro de la carpeta html se usaran los locales para crear otras 3 si es lo que se quiere, usando el Enum LocaleRef

      Predicate<String[]> arrayOfStringsIsNotEmpty = strArr-> strArr.length > 0;
      Predicate<List<?>> isEmptyLst = List::isEmpty;

      /**
       * dates
       */

      DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");
      DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");

      static String dateTimeFormattedToString()
      {
            return LocalDateTime.now()
                                .format(DATE_TIME_FORMATTER);
      }

      static String dateFormattedToString()
      {
            return LocalDate.now()
                            .format(DATE_FORMATTER);
      }
}
