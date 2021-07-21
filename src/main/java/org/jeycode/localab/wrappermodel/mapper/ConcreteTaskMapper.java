package org.jeycode.localab.wrappermodel.mapper;

import org.jeycode.localab.wrappermodel.ConcreteTask;
import org.jeycode.localab.wrappermodel.dto.ConcreteTaskDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {TaskFilesMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
      injectionStrategy = InjectionStrategy.CONSTRUCTOR, collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
      componentModel = "spring")
public interface ConcreteTaskMapper
{

      ConcreteTask reverse(ConcreteTaskDto concreteTaskDto);

      ConcreteTaskDto toDto(ConcreteTask concreteTask);
}
