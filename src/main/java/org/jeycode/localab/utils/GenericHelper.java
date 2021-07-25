package org.jeycode.localab.utils;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface GenericHelper
{

      /**
       * Constants
       */

      char SLASH = File.separatorChar;

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
