package org.jeycode.localab.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface GenericHelper
{

      DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");

      static String dateFormatted()
      {
            return LocalDateTime.now()
                                .format(DATE_FORMATTER);
      }
}
