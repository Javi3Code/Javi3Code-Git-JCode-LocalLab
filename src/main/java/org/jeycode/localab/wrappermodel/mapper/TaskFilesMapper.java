package org.jeycode.localab.wrappermodel.mapper;

import org.jeycode.localab.wrappermodel.TaskFiles;
import org.jeycode.localab.wrappermodel.dto.TaskFilesDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {HtmlMapper.class,CssFileMapper.class,JsFileMapper.class,ImgFileMapper.class,DocFileMapper.class},
      nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
      collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE, componentModel = "spring")
public interface TaskFilesMapper extends GenericMapper<TaskFiles,TaskFilesDto>
{

}
