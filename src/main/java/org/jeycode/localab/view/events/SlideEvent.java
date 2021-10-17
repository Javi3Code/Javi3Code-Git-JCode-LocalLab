package org.jeycode.localab.view.events;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public interface SlideEvent extends ActionListener
{

      int POSITION_OPEN = 1;
      int POSITION_CLOSED = 2;

      Component component();

      Timer timer();

      boolean isWindow();

      int speed();

      boolean fromVisible();

      void setFromVisible(boolean fromVisible);

      void setSpeed(int speed);

      int delay();

      void setDelay(int delay);

      int walked();

      void setWalked(int walked);

      int road();

      JC_Axis getAxis();

      int getInitialPosition();

      void setInitialPosition(int position);

      float alphaValueToPush();

      float getActualAlpha();

      float setActualAlpha(float alpha);

      Runnable firstRunnable();

      Runnable lastRunnable();

      Runnable nextStep();

      SlideEvent whenStart(Runnable firstRunnable);

      SlideEvent whenComplete(Runnable lastRunnable);

      void alphaOperation();

      void setAlphaOperation(Runnable alphaOperation);

      void resetEventValues();

      @Override
      default void actionPerformed(ActionEvent e)
      {
            Runnable doRun = walked() < road() ? nextStep() : lastStep();
            doRun.run();
      }

      default void changeSlideDirection()
      {
            timer().stop();
            changeInitialPosition();
            setWalked(road() - walked());
            timer().restart();
      }

      default boolean isRunning()
      {
            return timer().isRunning();
      }

      default void updateLocation()
      {
            int jump = jumpAdjusted();
            int value = getInitialPosition() == POSITION_OPEN ? jump : -jump;
            switch (getAxis())
            {
                  case AXIS_Y:
                        component().setLocation(getX(),getY() + value);
                        break;
                  case X_AXIS:
                        component().setLocation(getX() + value,getY());
                        break;
            }
            setWalked(walked() + jump);
      }

      default void alphaOperationToSet()
      {
            Runnable operationToSet = fromVisible() ? this::reduceAlpha : this::increaseAlpha;
            setAlphaOperation(operationToSet);
      }

      default void changeInitialPosition()
      {
            setInitialPosition(getInitialPosition() == POSITION_OPEN ? POSITION_CLOSED : POSITION_OPEN);
      }

      default void reduceAlpha()
      {
            float alpha = setActualAlpha(getActualAlpha() - alphaValueToPush());
            float newAlphaValue = alpha < 0f ? 0f : alpha;
            setActualAlpha(newAlphaValue);
      }

      default void increaseAlpha()
      {
            float alpha = getActualAlpha() + alphaValueToPush();
            float newAlphaValue = alpha > 1f ? 1f : alpha;
            setActualAlpha(newAlphaValue);
      }

      default int getX()
      {
            return component().getX();
      }

      default int getY()
      {
            return component().getY();
      }

      default void start()
      {
            runIfNotNull(firstRunnable());
            timer().start();
      }

      default void stop()
      {
            timer().stop();
            runIfNotNull(lastRunnable());
      }

      default Runnable lastStep()
      {
            return ()->
                  {
                        changeInitialPosition();
                        resetEventValues();
                        stop();
                  };
      }

      default int jumpAdjusted()
      {
            final int difference = walked() - road();
            return speed() > Math.abs(difference) ? Math.abs(difference) : speed();
      }

      static void runIfNotNull(Runnable runnable)
      {
            if (runnable != null)
            {
                  runnable.run();
            }
      }

}
