package org.jeycode.localab.view.events.visualevents;

import java.awt.Component;
import java.awt.Window;
import java.util.Optional;

import javax.swing.Timer;
import javax.validation.constraints.NotNull;

public final class JCLaboComponentSlideEvent implements SlideEvent
{

      private final Component component;
      private Window window;
      private int speed;
      private final boolean isWindow;
      private boolean fromVisible;
      private float alphaValueToPush;
      private final int delay;
      private final Timer timer;
      private int walked;
      private final int road;
      private Runnable firstRunnable;
      private Runnable lastRunnable;
      private Runnable alphaOperation;
      private final Runnable nextStep;
      private int initialPosition;
      private final JC_Axis axis;

      public JCLaboComponentSlideEvent(Component component,@NotNull Integer slideEventPosition,JC_Axis axis,Integer road,Integer speed,
            Integer delay,Float alpha)
      {
            this.component = component;
            this.axis = axis;
            this.road = Optional.ofNullable(Math.abs(road))
                                .orElse(axis == JC_Axis.X_AXIS ? component.getWidth() : component.getHeight());
            this.speed = Optional.ofNullable(speed)
                                 .orElse(10);
            this.delay = Optional.ofNullable(delay)
                                 .orElse(10);
            initialPosition = slideEventPosition;
            isWindow = component instanceof Window;
            if (isWindow)
            {
                  this.window = (Window)component;
                  this.alphaValueToPush = Optional.ofNullable(alpha)
                                                  .orElse(10f);
                  alphaOperationToSet();
            }
            nextStep = isWindow ? ()->
                  {
                        alphaOperation();
                        updateLocation();

                  } : this::updateLocation;
            timer = new Timer(this.delay,this);
      }

      @Override
      public Component component()
      {
            return component;
      }

      @Override
      public Timer timer()
      {
            return timer;
      }

      @Override
      public boolean isWindow()
      {
            return isWindow;
      }

      @Override
      public int speed()
      {
            return speed;
      }

      @Override
      public void setSpeed(int speed)
      {
            this.speed = speed;
      }

      @Override
      public int delay()
      {
            return delay;
      }

      @Override
      public void setDelay(int delay)
      {
            this.timer.setDelay(delay);
      }

      @Override
      public int walked()
      {
            return walked;
      }

      @Override
      public int road()
      {
            return road;
      }

      @Override
      public float alphaValueToPush()
      {
            return alphaValueToPush;
      }

      @Override
      public float getActualAlpha()
      {
            return window.getOpacity();
      }

      @Override
      public float setActualAlpha(float alpha)
      {
            window.setOpacity(alpha);
            return alpha;
      }

      @Override
      public Runnable firstRunnable()
      {
            return firstRunnable;
      }

      @Override
      public Runnable lastRunnable()
      {
            return lastRunnable;
      }

      @Override
      public SlideEvent whenStart(Runnable firstRunnable)
      {
            this.firstRunnable = firstRunnable;
            return this;
      }

      @Override
      public SlideEvent whenComplete(Runnable lastRunnable)
      {
            this.lastRunnable = lastRunnable;
            return this;
      }

      @Override
      public void alphaOperation()
      {
            alphaOperation.run();
      }

      @Override
      public void setAlphaOperation(Runnable alphaOperation)
      {
            this.alphaOperation = alphaOperation;
      }

      @Override
      public Runnable nextStep()
      {
            return nextStep;
      }

      @Override
      public int getInitialPosition()
      {
            return initialPosition;
      }

      @Override
      public void setInitialPosition(int position)
      {
            initialPosition = position;
      }

      @Override
      public JC_Axis getAxis()
      {
            return axis;
      }

      @Override
      public void resetEventValues()
      {
            setWalked(0);
      }

      @Override
      public void setWalked(int walked)
      {
            this.walked = walked;
      }

      @Override
      public boolean fromVisible()
      {
            return fromVisible;
      }

      @Override
      public void setFromVisible(boolean fromVisible)
      {
            this.fromVisible = fromVisible;
      }

}
