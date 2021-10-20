package org.jeycode.localab.applicationcontext.service.serviceimpl;

import org.jeycode.localab.applicationcontext.model.ApplicationContext;
import org.jeycode.localab.applicationcontext.repository.ApplicationContextRepository;
import org.jeycode.localab.applicationcontext.service.ApplicationContextLoader;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationContextLoaderImpl implements ApplicationContextLoader
{

      private final ApplicationContextRepository applicationContextRepository;

      @Override
      public ApplicationContext getApplicationContextObj()
      {
            return applicationContextRepository.findAll()
                                               .get(0);
      }

      @Override
      public ApplicationContext saveOrUpdate(ApplicationContext applicationContext)
      {
            return applicationContextRepository.save(applicationContext);
      }

}
