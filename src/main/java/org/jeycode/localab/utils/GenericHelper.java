package org.jeycode.localab.utils;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;

import org.jeycode.localab.configmodel.AppConfigObj;

public class GenericHelper
{

      public static AppConfigObj applicationConfigObj;

      /**
       * Constants
       */
      public static String EMPTY_STRING = "";
      public static char EMPTY_CHAR = '\0';
      public static char PARAMETER_INDICATOR='-';
      public static String Generic_SLASH = File.separator;
      public static String Rigth_SLASH = "/";
      public static String Left_SALSH = "\\";
      public static String SUFFIX_CONFIG_YML = "_config.yml";

      /*
       * Dir Task Model Structure
       */
      public static String PARENT_TASKFILES_DIR = "Work_Files";
      public static String ORIGIN_BACKUP = "origin_backup";
      public static String TASK_BACKUP = "task_backup";
// Hasta aquí mismo nivel detro del dir de la tarea
      public static String RESOURCES = "resources";
//Hasta aquí las carpetas para cada recurso - Las que no vemos aquí son las del Enum -> FileExtension
//Dentro de la carpeta html se usaran los locales para crear otras 3 si es lo que se quiere, usando el Enum LocaleRef

      public static Predicate<String[]> arrayOfStringsIsNotEmpty = strArr-> strArr.length > 0;
      public static Predicate<List<?>> isEmptyLst = List::isEmpty;

      /**
       * dates
       */

      public static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");
      public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");

      public static String dateTimeFormattedToString()
      {
            return LocalDateTime.now()
                                .format(DATE_TIME_FORMATTER);
      }

      public static String dateFormattedToString()
      {
            return LocalDate.now()
                            .format(DATE_FORMATTER);
      }

}
