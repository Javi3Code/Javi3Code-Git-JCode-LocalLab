package org.jeycode.localab.taskmodel.model.mapper;

import org.jeycode.localab.taskmodel.model.TaskFiles;
import org.jeycode.localab.taskmodel.model.dto.TaskFilesDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * 
 * @see GenericMapper
 * @see TaskFiles
 * @see TaskFilesDto
 * @see HtmlMapper
 * @see CssFileMapper
 * @see JsFileMapper
 * @see ImgFileMapper
 * @see DocFileMapper
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Mapper(uses = {HtmlMapper.class,CssFileMapper.class,JsFileMapper.class,ImgFileMapper.class,DocFileMapper.class},
      nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
      collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE, componentModel = "spring")
public interface TaskFilesMapper extends GenericMapper<TaskFiles,TaskFilesDto>
{

}
