package org.jeycode.localab.taskmodel.controller;

import java.util.List;
import java.util.function.Predicate;

import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.jeycode.localab.taskmodel.service.ConcreteTaskAccessService;
import org.jeycode.localab.taskmodel.service.serviceimpl.ConcreteTaskAccessServiceImpl;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Controller de las operaciones relacionadas a {@link ConcreteTask} contra la
 * database. Expone los métodos, pero oculta sus implementaciones.
 * 
 * @see ConcreteTaskAccessServiceImpl
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Controller
@RequiredArgsConstructor
public class ConcreteTaskController
{

      private final ConcreteTaskAccessService concreteTaskService;

      public List<ConcreteTask> findAll()
      {
            return concreteTaskService.findAll();
      }

      public ConcreteTask findById(String id)
      {
            return concreteTaskService.findById(id);
      }

      public ConcreteTask findOneIf(Predicate<?> is)
      {
            return concreteTaskService.findOneIf(is);
      }

      public boolean deleteAll()
      {
            return concreteTaskService.deleteAll();
      }

      public ConcreteTask addOne(ConcreteTask entity)
      {
            return concreteTaskService.addOne(entity);
      }

      public ConcreteTask updateOne(ConcreteTask entity)
      {
            return concreteTaskService.updateOne(entity);
      }

      public boolean deleteOne(ConcreteTask entity)
      {
            return concreteTaskService.deleteOne(entity);
      }

      public ConcreteTask updateAll(ConcreteTask entity)
      {
            return concreteTaskService.updateAll(entity);
      }

}
