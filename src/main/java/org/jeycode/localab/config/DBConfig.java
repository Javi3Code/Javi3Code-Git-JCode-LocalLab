package org.jeycode.localab.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DBConfig
{

      private final Environment environment;

      @Bean
      public DataSource datasource()
      {
            return DataSourceBuilder.create()
                                    .driverClassName("org.sqlite.JDBC")
                                    .url("jdbc:sqlite:resource:jclab.db")
                                    .username("")
                                    .password("")
                                    .build();
      }
}
