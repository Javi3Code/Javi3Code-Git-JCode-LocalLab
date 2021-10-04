package org.jeycode.localab.view.utils;

import static java.lang.Thread.sleep;
import java.awt.Dimension;
import java.awt.Toolkit;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Views
{

      public static final char NORTH = 'n';
      public static final char SOUTH = 's';
      public static final char EAST = 'e';
      public static final char WEST = 'w';
      public static final Dimension screenDimension = Toolkit.getDefaultToolkit()
                                                             .getScreenSize();

}
