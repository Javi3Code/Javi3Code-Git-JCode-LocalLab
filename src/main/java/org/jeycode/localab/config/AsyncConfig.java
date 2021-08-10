package org.jeycode.localab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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

      private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime()
                                                             .availableProcessors();

      @Bean(destroyMethod = "destroy")
      public ThreadPoolTaskExecutor threadPoolTaskExecutor()
      {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setKeepAliveSeconds(1);
            executor.setThreadPriority(Thread.MAX_PRIORITY);
            executor.setMaxPoolSize(AVAILABLE_PROCESSORS + 2);
            executor.setQueueCapacity(AVAILABLE_PROCESSORS + 2);
            executor.setCorePoolSize(4);
            executor.setThreadGroupName("Application-Task");
            executor.setThreadNamePrefix("Jey-Code-Thread");
            executor.initialize();
            return executor;
      }

}
