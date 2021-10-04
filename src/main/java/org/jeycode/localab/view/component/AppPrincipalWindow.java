package org.jeycode.localab.view.component;

import javax.swing.JFrame;

import org.jeycode.localab.view.events.JCLaboWindowDragEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
@Scope("singleton")
@Getter
public final class AppPrincipalWindow extends JFrame
{

      private final VisualInfoArea infoArea;

      public AppPrincipalWindow(VisualInfoArea infoArea)
      {
            this.infoArea = infoArea;
            putDragEvent();
      }

      public void putDragEvent()
      {
            JCLaboWindowDragEvent.addDragEventListenerTo(this);
      }

      public boolean start()
      {
            return false;
      }

      public boolean close()
      {
            return false;
      }

      private static final long serialVersionUID = 1L;

}
