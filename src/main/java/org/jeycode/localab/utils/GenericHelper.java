package org.jeycode.localab.utils;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;

import org.jeycode.localab.configmodel.AppConfigObj;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class GenericHelper
{

      public static final String ASYNC_EXECUTOR = "threadPoolTaskExecutor";

      /**
       * Constants
       */
      public static final String EMPTY_STRING = "";
      public static final char EMPTY_CHAR = '\0';
      public static final char PARAMETER_INDICATOR = '-';
      public static final String Generic_SLASH = File.separator;
      public static final String Rigth_SLASH = "/";
      public static final String Left_SALSH = "\\";
      public static final String SUFFIX_CONFIG_YML = "_config.yml";

      /*
       * Dir Task Model Structure
       */
      public static final String PARENT_TASKFILES_DIR = "Work_Files";
      public static final String ORIGIN_BACKUP = "origin_backup";
      public static final String TASK_BACKUP = "task_backup";
// Hasta aquí mismo nivel detro del dir de la tarea
      public static final String RESOURCES = "resources";
//Hasta aquí las carpetas para cada recurso - Las que no vemos aquí son las del Enum -> FileExtension
//Dentro de la carpeta html se usaran los locales para crear otras 3 si es lo que se quiere, usando el Enum LocaleRef

      public static final Predicate<String[]> arrayOfStringsIsNotEmpty = strArr-> strArr.length > 0;
      public static final Predicate<List<?>> isEmptyLst = List::isEmpty;

      /**
       * dates
       */

      public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");
      public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");

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
