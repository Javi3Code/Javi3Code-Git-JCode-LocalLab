package org.jeycode.localab.wrappermodel.mapper;

import org.jeycode.localab.wrappermodel.filemodel.HtmlFiles;
import org.jeycode.localab.wrappermodel.filemodeldto.HtmlFilesDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

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
