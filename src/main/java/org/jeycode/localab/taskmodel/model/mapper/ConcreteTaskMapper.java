package org.jeycode.localab.taskmodel.model.mapper;

import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDtoToShow;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * 
 * @see GenericMapper
 * @see ConcreteTaskDto
 * @see ConcreteTaskDto
 * @see TaskFilesMapper
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Mapper(uses = {TaskFilesMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
      injectionStrategy = InjectionStrategy.CONSTRUCTOR, collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
      componentModel = "spring")
public interface ConcreteTaskMapper extends GenericMapper<ConcreteTask,ConcreteTaskDto>
{

      ConcreteTask reverseDtoToShow(ConcreteTaskDtoToShow dto);

      ConcreteTaskDtoToShow toDtoToShow(ConcreteTask concreteTask);
}
