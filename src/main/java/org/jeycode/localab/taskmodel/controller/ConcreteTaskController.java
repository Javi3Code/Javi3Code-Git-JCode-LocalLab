package org.jeycode.localab.taskmodel.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.service.ConcreteTaskAccessService;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Controller de las operaciones relacionadas a {@link ConcreteTaskDto} contra
 * la database. Expone los métodos, pero oculta sus implementaciones.
 * 
 * @see ConcreteTaskAccessService
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

      private final ConcreteTaskAccessService concreteTaskAccessServiceImpl;

      public List<? extends ConcreteTaskDto> findAll()
      {
            return concreteTaskAccessServiceImpl.findAll();
      }

      public ConcreteTaskDto findById(String id)
      {
            return concreteTaskAccessServiceImpl.findById(id);
      }

      public List<? extends ConcreteTaskDto> findAllSortByCreationDateAsc()
      {
            return concreteTaskAccessServiceImpl.findAllSortByCreationDate(true);
      }

      public List<? extends ConcreteTaskDto> findAllSortByCreationDateDesc()
      {
            return concreteTaskAccessServiceImpl.findAllSortByCreationDate(false);
      }

      public ConcreteTaskDto addOne(@Valid ConcreteTaskDto concTaskDto)
      {
            return concreteTaskAccessServiceImpl.addOne(concTaskDto);
      }

      public Set<? extends ConcreteTaskDto> addAll(@Valid Set<? extends ConcreteTaskDto> concTaskDtos)
      {
            return concreteTaskAccessServiceImpl.addAll(concTaskDtos);
      }

      public ConcreteTaskDto updateOne(@Valid ConcreteTaskDto concTaskDto)
      {
            return concreteTaskAccessServiceImpl.updateOne(concTaskDto);
      }

      public Set<? extends ConcreteTaskDto> updateAll(@Valid Set<? extends ConcreteTaskDto> concTaskDtos)
      {
            return concreteTaskAccessServiceImpl.updateAll(concTaskDtos);
      }

      public boolean deleteOne(@Valid ConcreteTaskDto concTaskDto)
      {
            return concreteTaskAccessServiceImpl.deleteOne(concTaskDto);
      }

      public boolean deleteAll()
      {
            return concreteTaskAccessServiceImpl.deleteAll();
      }

}
