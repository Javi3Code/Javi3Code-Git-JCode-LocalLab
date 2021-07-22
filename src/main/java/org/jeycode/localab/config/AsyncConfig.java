package org.jeycode.localab.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * Clase para configurar la asincronía de la app.
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Configuration
@EnableAsync(proxyTargetClass = true)
public class AsyncConfig
{

      @Bean
      public ExecutorService threadPoolExecutor()
      {

            int availableProcessors = Runtime.getRuntime()
                                             .availableProcessors();
            BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(availableProcessors + 2);
            return new ThreadPoolExecutor(availableProcessors,availableProcessors + 2,2,TimeUnit.SECONDS,workQueue);
      }

}
