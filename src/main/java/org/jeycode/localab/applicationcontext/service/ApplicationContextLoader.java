package org.jeycode.localab.applicationcontext.service;

import org.jeycode.localab.applicationcontext.model.ApplicationContext;

public interface ApplicationContextLoader
{

      ApplicationContext getApplicationContextObj();
      
      ApplicationContext saveOrUpdate(ApplicationContext applicationContext);
      
}
