package org.jeycode.localab.view.component;

import javax.swing.JFrame;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import manipulateComponents.Constants.AlphaValue;
import manipulateComponents.Constants.CardinalPoint;
import manipulateComponents.Constants.Velocity;
import manipulateComponents.pattern.abstractWat.effectsComplete.ManipulateWindowEffect;
import putMovementToComponent.PutMovementToComponent;

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
@RequiredArgsConstructor
public final class AppPrincipalWindow extends JFrame
{

      private final VisualInfoArea infoArea;

      public void putDragEvent()
      {
            PutMovementToComponent.newInstance()
                                  .giveMovementToTheWindow(this,0.5f);
      }

      public boolean start()
      {
            return false;
      }

      public boolean close()
      {
            int road = 1000;
            ManipulateWindowEffect.push(this,Velocity.ULTRAGEAR,road,CardinalPoint.EAST,true,AlphaValue.ALPHA_WindowEffects);
            return false;
      }

      private static final long serialVersionUID = 1L;

}
