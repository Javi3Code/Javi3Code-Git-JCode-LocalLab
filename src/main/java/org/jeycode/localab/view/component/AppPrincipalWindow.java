package org.jeycode.localab.view.component;

import static org.jeycode.localab.view.utils.Views.MAX_HEIGHT;
import static org.jeycode.localab.view.utils.Views.MAX_WIDTH;
import static org.jeycode.localab.view.utils.Views.screenDimension;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.WindowConstants;

import org.jeycode.localab.view.component.panel.PrincipalPanel;
import org.jeycode.localab.view.events.visualevents.JCLaboComponentSlideEvent;
import org.jeycode.localab.view.events.visualevents.JCLaboWindowDragEvent;
import org.jeycode.localab.view.events.visualevents.JC_Axis;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 
 * Frame principal que abarcará tanto la ventana de logs como la command line
 * runner.
 * 
 * @author Javier Pérez Alonso
 *
 *         3 oct. 2021
 *
 */

@Component
@RequiredArgsConstructor
@Scope("singleton")
public final class AppPrincipalWindow extends JFrame
{

      @Getter
      private JMenu menu;
      @Getter
      private final PrincipalPanel panel;
      private JCLaboComponentSlideEvent slideEvent;
      @Getter
      @Setter
      private boolean canClose;

      public void putDragEvent()
      {
            setUndecorated(true);
            JCLaboWindowDragEvent.addDragEventListenerTo(this);
      }

      public boolean start()
      {
            setInitialBounds();
            putDragEvent();
            slideEvent = new JCLaboComponentSlideEvent(this,this.getX(),JC_Axis.X_AXIS,2000,null,null,1.0f);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            tempElements();
            setVisible(true);
            return false;
      }

      private void tempElements()
      {
//            infoArea.setVisible(false);
            this.addKeyListener(new KeyAdapter()
            {

                  @Override
                  public void keyTyped(KeyEvent e)
                  {
                        int keyCode = KeyEvent.getExtendedKeyCodeForChar(e.getKeyChar());
                        if (keyCode == KeyEvent.VK_ESCAPE)
                        {
                              System.exit(0);
                        }
                  }
            });
            getContentPane().setLayout(null);
//            JButton btn = new JButton("Botón");
//
//            getContentPane().add(btn);
//            JLabel labl = new JLabel("asdadad");
//            labl.setBounds(300,300,300,300);
//            getContentPane().add(labl);
            panel.setVisible(true);
            panel.setBounds(0,0,this.getWidth(),this.getHeight());
            getContentPane().add(panel);
            panel.setLocation(0,0);
            panel.init();
      }

      public boolean close()
      {
            return true;
      }

      private void setInitialBounds()
      {
            double screenWidth = screenDimension.getWidth();
            double screenHeight = screenDimension.getHeight();
            int width = (int)(screenWidth <= MAX_WIDTH ? screenWidth : MAX_WIDTH);
            int height = (int)(screenHeight <= MAX_HEIGHT ? screenHeight : MAX_HEIGHT);
            Dimension dimension = new Dimension(width,height);
            this.setSize(dimension);
            this.setPreferredSize(dimension);
            this.setMaximumSize(dimension);
            this.setMinimumSize(dimension);
      }

      private static final long serialVersionUID = 1L;

}
