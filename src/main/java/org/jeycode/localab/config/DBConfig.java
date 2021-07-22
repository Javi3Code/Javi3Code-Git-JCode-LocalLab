package org.jeycode.localab.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteDataSource;

@Configuration
public class DBConfig
{

      @Bean
      public DataSource datasource()
      {
            return new SQLiteDataSource();
      }
}
