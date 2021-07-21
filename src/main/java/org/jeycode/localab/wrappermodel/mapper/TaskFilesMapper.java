package org.jeycode.localab.wrappermodel.mapper;

import org.jeycode.localab.wrappermodel.TaskFiles;
import org.jeycode.localab.wrappermodel.dto.TaskFilesDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {HtmlMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
      injectionStrategy = InjectionStrategy.CONSTRUCTOR, collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
      componentModel = "spring")
public interface TaskFilesMapper
{

      TaskFiles reverse(TaskFilesDto taskFilesDto);

      TaskFilesDto toDto(TaskFiles taskFiles);
}
