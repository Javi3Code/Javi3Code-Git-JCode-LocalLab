package org.jeycode.localab.taskmodel.controller;

import javax.validation.Valid;

import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.service.ConcreteTaskAccessService;
import org.jeycode.localab.taskmodel.service.serviceimpl.ConcreteTaskAccessServiceImpl;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Controller de las operaciones relacionadas a {@link ConcreteTaskDto} contra
 * la database. Expone los métodos, pero oculta sus implementaciones.
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

//
//      public List<ConcreteTaskDto> findAll()
//      {
//            return concreteTaskService.findAll(); 
//      }
//
//      public ConcreteTaskDto findById(String id)
//      {
//            return concreteTaskService.findById(id);
//      }
//
//      public ConcreteTaskDto findOneIf(Predicate<?> is)
//      {
//            return concreteTaskService.findOneIf(is);
//      }
//
//      public boolean deleteAll()
//      {
//            return concreteTaskService.deleteAll();
//      }
//
      public ConcreteTaskDto addOne(@Valid ConcreteTaskDto concTaskDto)
      {
            return concreteTaskService.addOne(concTaskDto);
      }
//
//      public ConcreteTaskDto updateOne(ConcreteTaskDto concTaskDto)
//      {
//            return concreteTaskService.updateOne(entity);
//      }
//
//      public boolean deleteOne(ConcreteTaskDto concTaskDto)
//      {
//            return concreteTaskService.deleteOne(concTaskDto);
//      }
//
//      public ConcreteTaskDto updateAll(Set<ConcreteTaskDto> concTaskDtos)
//      {
//            return concreteTaskService.updateAll(concTaskDtos);
//      }

}
