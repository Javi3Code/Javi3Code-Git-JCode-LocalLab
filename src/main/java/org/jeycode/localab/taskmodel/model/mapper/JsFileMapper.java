package org.jeycode.localab.taskmodel.model.mapper;

import org.jeycode.localab.taskmodel.model.filemodel.JsFile;
import org.jeycode.localab.taskmodel.model.filemodeldto.JsFileDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * 
 * @see GenericMapper
 * @see JsFile
 * @see JsFileDto
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
      injectionStrategy = InjectionStrategy.CONSTRUCTOR, collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
      componentModel = "spring")
public interface JsFileMapper extends GenericMapper<JsFile,JsFileDto>
{

}
