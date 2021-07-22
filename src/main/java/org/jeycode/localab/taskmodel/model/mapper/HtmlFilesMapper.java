package org.jeycode.localab.taskmodel.model.mapper;

import org.jeycode.localab.taskmodel.model.filemodel.HtmlFiles;
import org.jeycode.localab.taskmodel.model.filemodeldto.HtmlFilesDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * 
 * @see GenericMapper
 * @see HtmlFiles
 * @see HtmlFilesDto
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
      injectionStrategy = InjectionStrategy.CONSTRUCTOR, collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
      componentModel = "spring")
public interface HtmlFilesMapper extends GenericMapper<HtmlFiles,HtmlFilesDto>
{

      @Override
      HtmlFiles reverse(HtmlFilesDto htmlFilesDto);

      @Override
      HtmlFilesDto toDto(HtmlFiles htmlFiles);
}
