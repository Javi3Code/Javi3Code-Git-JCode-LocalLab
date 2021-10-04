package org.jeycode.localab.view.events;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

import javax.swing.Timer;

public interface SlideEvent extends ActionListener
{

      Component component();

      Timer timer();

      boolean isWindow();

      boolean fromVisible();

      int speed();

      int delay();

      void setDelay();

      void start();

      void stop();

      int walked();

      int road();

      float alphaValueToPush();

      float getActualAlpha();

      float setActualAlpha(float alpha);

      Runnable runnable();

      SlideEvent whenComplete(Runnable runnable);

      Supplier<Float> alphaOperation();

      void setAlphaOperation(Supplier<Float> alphaOperation);

      @Override
      default void actionPerformed(ActionEvent e)
      {

      }

      default void alphaOperationToSet()
      {
            setAlphaOperation(()-> fromVisible() ? reduceAlpha() : increaseAlpha());
      }

      default void setOpacityValue()
      {
            ((Window)component()).setOpacity(alphaOperation().get());
      }

      default float reduceAlpha()
      {
            float alpha = setActualAlpha(getActualAlpha() - alphaValueToPush());
            return alpha < 0f ? setActualAlpha(0f) : alpha;
      }

      default float increaseAlpha()
      {
            float alpha = setActualAlpha(getActualAlpha() + alphaValueToPush());
            return alpha > 1f ? setActualAlpha(1f) : alpha;
      }

      default int getX()
      {
            return component().getX();
      }

      default int getY()
      {
            return component().getY();
      }

}
