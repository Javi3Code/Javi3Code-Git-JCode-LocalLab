package org.jeycode.localab.wrappermodel.mapper;

import org.jeycode.localab.wrappermodel.filemodel.Html;
import org.jeycode.localab.wrappermodel.filemodeldto.HtmlDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {HtmlFilesMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
      injectionStrategy = InjectionStrategy.CONSTRUCTOR, collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
      componentModel = "spring")
public interface HtmlMapper
{

      Html reverse(HtmlDto htmlDto);

      HtmlDto toDto(Html html);

}
