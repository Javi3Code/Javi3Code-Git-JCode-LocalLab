package org.jeycode.localab.view.utils;

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

      /*
       * Dimension Constants
       */
      public static final Dimension screenDimension = Toolkit.getDefaultToolkit()
                                                             .getScreenSize();
      public static double MAX_WIDTH = 1920.0;
      public static double MAX_HEIGHT = 1080.0;
      public static final Dimension maxScreenDimension = new Dimension((int)MAX_WIDTH,(int)MAX_HEIGHT);

}
