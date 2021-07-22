package org.jeycode.localab.taskmodel.model.mapper;

import org.mapstruct.Mapper;

/**
 * 
 * Interface que trabaja junto MapStruct {@link Mapper} en sus implementaciones
 * para generar los métodos necesarios para el mapeo simple a DTO y reversa.
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 * @param <Entity>
 * @param <Dto>
 */
public interface GenericMapper<Entity,Dto>
{

      Entity reverse(Dto dto);

      Dto toDto(Entity entity);
}
