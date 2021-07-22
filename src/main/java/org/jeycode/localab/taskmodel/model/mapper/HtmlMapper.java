package org.jeycode.localab.taskmodel.model.mapper;

import org.jeycode.localab.taskmodel.model.filemodel.Html;
import org.jeycode.localab.taskmodel.model.filemodeldto.HtmlDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * 
 * @see GenericMapper
 * @see Html
 * @see HtmlDto
 * @see HtmlFilesMapper
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Mapper(uses = {HtmlFilesMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
      injectionStrategy = InjectionStrategy.CONSTRUCTOR, collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
      componentModel = "spring")
public interface HtmlMapper extends GenericMapper<Html,HtmlDto>
{

}
