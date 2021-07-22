package org.jeycode.localab.taskmodel.service.serviceimpl;

import java.util.List;
import java.util.function.Predicate;

import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.jeycode.localab.taskmodel.repository.ConcreteTaskRepository;
import org.jeycode.localab.taskmodel.service.ConcreteTaskAccessService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Servicio que implementa los métodos de {@link ConcreteTaskAccessService} para
 * encapsular todo el trabajo espeso de esas operaciones.
 * 
 * 
 * @see ConcreteTask
 * @see ConcreteTaskRepository
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ConcreteTaskAccessServiceImpl implements ConcreteTaskAccessService
{

      private final ConcreteTaskRepository concreteTaskRepository;

      @Override
      public List<ConcreteTask> findAll()
      {
            return null;
      }

      @Override
      public ConcreteTask findById(String id)
      {
            return null;
      }

      @Override
      public ConcreteTask findOneIf(Predicate<?> is)
      {
            return null;
      }

      @Override
      public boolean deleteAll()
      {
            return false;
      }

      @Override
      public ConcreteTask addOne(ConcreteTask entity)
      {
            return null;
      }

      @Override
      public ConcreteTask updateOne(ConcreteTask entity)
      {
            return null;
      }

      @Override
      public boolean deleteOne(ConcreteTask entity)
      {
            return false;
      }

      @Override
      public ConcreteTask updateAll(ConcreteTask entity)
      {
            return null;
      }

}
