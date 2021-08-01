package org.jeycode.localab.taskmodel.service;

import java.util.List;
import java.util.Set;

/**
 * 
 * Interface genérica para todos los Servicios del modelo de tareas.
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 * @param <Dto> DTO de la entidad a tratar.
 * @param <Id>  La PK de la entidad.
 */
public interface GenericService<Dto,Id>
{

      List<? extends Dto> findAll();

      List<? extends Dto> findAllSortByCreationDate(boolean asc);

      Dto findById(Id id);

      boolean deleteAll();

      Dto addOne(Dto dto);

      Set<? extends Dto> addAll(Set<? extends Dto> dtos);

      Dto updateOne(Dto dto);

      Set<? extends Dto> updateAll(Set<? extends Dto> dtos);

      boolean deleteOne(Dto dto);

}
