package org.jeycode.localab.taskmodel.service.serviceimpl;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.jeycode.localab.utils.GenericHelper.isEmptyLst;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.jeycode.localab.taskmodel.err.TaskModelException;
import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDtoToShow;
import org.jeycode.localab.taskmodel.model.mapper.ConcreteTaskMapper;
import org.jeycode.localab.taskmodel.repository.ConcreteTaskRepository;
import org.jeycode.localab.taskmodel.service.ConcreteTaskAccessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class ConcreteTaskAccessServiceImpl implements ConcreteTaskAccessService
{

      private final ConcreteTaskRepository concreteTaskRepository;
      private final ConcreteTaskMapper mapper;

      /**
       * 
       *
       * Overwritten method findAll : busca todas las task y las devuelve mapeadas a
       * {@link ConcreteTaskDtoToShow}.
       *
       */
      @Override
      public List<? extends ConcreteTaskDto> findAll()
      {
            List<ConcreteTaskDto> data = concreteTaskRepository.findAll()
                                                               .stream()
                                                               .map(mapper::toDtoToShow)
                                                               .collect(toList());

            return validateIfListIsNotEmptyList(data);

      }

      /**
       * 
       *
       * Overwritten method findById : Busca una Task concreta y la devuelve mapeada a
       * {@link ConcreteTaskDtoToShow}.
       * 
       * @param id : El valor de la primary de la task.
       * 
       * @return la task mapeada a {@link ConcreteTaskDtoToShow}.
       *
       */
      @Override
      public ConcreteTaskDtoToShow findById(String id)
      {
            return concreteTaskRepository.findById(id)
                                         .map(mapper::toDtoToShow)
                                         .orElseThrow(()->
                                               {
                                                     log.error("Se tratan de obtener un task, pero no existe.");
                                                     return new TaskModelException("No se encuentra la tarea elegida.",
                                                                                   "Asegurate de que la tarea existe o vuelve a crear una de nuevo.");
                                               });
      }

      /**
       * 
       *
       * Overwritten method findAllSortByCreationDate : Obtener Las task en orden de
       * creación determinado.
       * 
       * @param asc : Determina el orden ascendente (true) o descendente (false).
       * 
       * @return la lista de task mapeada a {@link ConcreteTaskDtoToShow}.
       *
       */
      @Override
      public List<? extends ConcreteTaskDto> findAllSortByCreationDate(boolean asc)
      {
            List<ConcreteTask> tasks = asc ? concreteTaskRepository.findByOrderByCreationDateAsc() :
                  concreteTaskRepository.findByOrderByCreationDateDesc();

            return validateIfListIsNotEmptyList(tasks.stream()
                                                     .map(mapper::toDtoToShow)
                                                     .collect(toList()));

      }

      @Override
      public ConcreteTaskDtoToShow addOne(ConcreteTaskDto dto)
      {
            return saveOrUpdate(dto,"guardar");

      }

      @Override
      public Set<? extends ConcreteTaskDto> addAll(Set<? extends ConcreteTaskDto> dtos)
      {

            return saveOrUpdateAllthis(dtos,this::addOne);
      }

      @Override
      public ConcreteTaskDtoToShow updateOne(ConcreteTaskDto dto)
      {
            return saveOrUpdate(dto,"actualizar");
      }

      @Override
      public Set<? extends ConcreteTaskDto> updateAll(Set<? extends ConcreteTaskDto> dtos)
      {
            return saveOrUpdateAllthis(dtos,this::updateOne);
      }

      @Override
      public boolean deleteOne(ConcreteTaskDto dto)
      {
            try
            {
                  concreteTaskRepository.delete(mapper.reverse(dto));
                  return true;
            }
            catch (Exception ex)
            {
                  logErr(ex);
                  return false;
            }

      }

      /**
       * 
       *
       * Overwritten method deleteAll : Borrar todos los task persistidos.
       *
       * @return si se ha realizado el borrado de forma correcta.
       * 
       */
      @Override
      public boolean deleteAll()
      {
            try
            {
                  concreteTaskRepository.deleteAll();
                  return true;
            }
            catch (Exception ex)
            {
                  logErr(ex);
                  return false;
            }
      }

      /*
       * PRIVATE SERVICE METHODS
       */

      private List<? extends ConcreteTaskDto> validateIfListIsNotEmptyList(List<? extends ConcreteTaskDto> data)
      {
            return Optional.of(data)
                           .filter(isEmptyLst.negate())
                           .orElseThrow(()->
                                 {
                                       log.error("Se tratan de obtener los task, pero no existen aún.");
                                       return new TaskModelException("No existen tareas guardadas actualmente.",
                                                                     "Agrega una nueva tarea y guardala.");
                                 });
      }

      private ConcreteTaskDtoToShow saveOrUpdate(ConcreteTaskDto dto,String errMsgAction)
      {
            try
            {
                  return mapper.toDtoToShow(concreteTaskRepository.save(mapper.reverse(dto)));
            }
            catch (Exception ex)
            {
                  logErr(ex);
                  throw new TaskModelException("Ocurrió un error al tratar de " + errMsgAction + " el task [" + dto.getTaskname() + "]",
                                               ex.getMessage());
            }
      }

      private Set<? extends ConcreteTaskDto> saveOrUpdateAllthis(Set<? extends ConcreteTaskDto> dtos,
                                                                 Function<? super ConcreteTaskDto,? extends ConcreteTaskDto> operation)
      {
            return dtos.stream()
                       .map(operation)
                       .collect(toSet());
      }

      private void logErr(Exception ex)
      {
            log.error("Error msg: " + ex.getMessage() + " // " + ex.getLocalizedMessage());
      }

}
