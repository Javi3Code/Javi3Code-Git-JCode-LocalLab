package org.jeycode.localab.view.events;

import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Javier Pérez Alonso
 *
 *         4 oct. 2021
 *
 */
public final class JCLaboWindowDragEvent
{

      private int x,y;
      private final Window window;
      private static final float ALPHA = 0.7f;

      private JCLaboWindowDragEvent(Window window)
      {
            this.window = window;
      }

      public static void addDragEventListenerTo(Window window)
      {
            new JCLaboWindowDragEvent(window).giveMovementToTheWindow();
      }

      public void giveMovementToTheWindow()
      {
            window.addMouseListener(new MouseAdapter()
            {

                  @Override
                  public void mousePressed(MouseEvent e)
                  {
                        x = e.getX();
                        y = e.getY();
                  }

                  @Override
                  public void mouseReleased(MouseEvent e)
                  {
                        window.setOpacity(1f);
                  }

            });
            window.addMouseMotionListener(new MouseAdapter()
            {

                  @Override
                  public void mouseDragged(MouseEvent e)
                  {
                        window.setLocation(window.getLocation().x + e.getX() - x,window.getLocation().y + e.getY() - y);
                        window.setOpacity(ALPHA);
                  }
            });
      }

}