package org.jeycode.localab.taskmodel.service;

import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * Interface genérica para todos los Servicios del modelo de tareas.
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 * @param <Entity> La entidad a tratar.
 * @param <Id>     La PK de la entidad.
 */
public interface GenericService<Entity,Id>
{

      List<Entity> findAll();

      Entity findById(Id id);

      Entity findOneIf(Predicate<?> is);

      boolean deleteAll();

      Entity addOne(Entity entity);

      Entity updateOne(Entity entity);

      boolean deleteOne(Entity entity);

      Entity updateAll(Entity entity);

}
