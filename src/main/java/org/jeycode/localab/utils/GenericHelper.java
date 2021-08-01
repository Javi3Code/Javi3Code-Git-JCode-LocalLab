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
