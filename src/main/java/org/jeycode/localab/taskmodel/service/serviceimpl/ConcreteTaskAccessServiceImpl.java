package org.jeycode.localab.taskmodel.service.serviceimpl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import org.jeycode.localab.taskmodel.err.TaskModelException;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDtoToShow;
import org.jeycode.localab.taskmodel.model.mapper.ConcreteTaskMapper;
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
 * @see ConcreteTaskDto
 * @see ConcreteTaskDtoToShow
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
      private final ConcreteTaskMapper mapper;
      private final Predicate<List<ConcreteTaskDto>> isEmptyLst = List::isEmpty;

      @Override
      public List<ConcreteTaskDto> findAll()
      {
            List<ConcreteTaskDto> data = concreteTaskRepository.findAll()
                                                               .stream()
                                                               .map(mapper::toDtoToShow)
                                                               .collect(toList());

            Optional.of(data)
                    .filter(isEmptyLst.negate())
                    .orElseThrow(()-> new TaskModelException("No existen tareas guardadas actualmente.",
                                                             "Agrega una nueva tarea y guardala."));
            return data;
      }

      @Override
      public ConcreteTaskDtoToShow findById(String id)
      {
            return null;
      }

      @Override
      public List<ConcreteTaskDto> findAllSortByCreationDate(boolean asc)
      {
            return null;
      }

      @Override
      public boolean deleteAll()
      {
            return false;
      }

      @Override
      public ConcreteTaskDtoToShow addOne(ConcreteTaskDto dto)
      {
            return null;
      }

      @Override
      public ConcreteTaskDtoToShow updateOne(ConcreteTaskDto dto)
      {
            return null;
      }

      @Override
      public boolean deleteOne(ConcreteTaskDto dto)
      {
            return false;
      }

      @Override
      public ConcreteTaskDto updateAll(Set<ConcreteTaskDto> dto)
      {
            return null;
      }

}
