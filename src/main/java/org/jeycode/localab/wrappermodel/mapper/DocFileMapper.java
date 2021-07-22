package org.jeycode.localab.wrappermodel.mapper;

import org.jeycode.localab.wrappermodel.DocFile;
import org.jeycode.localab.wrappermodel.filemodeldto.DocFileDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
      injectionStrategy = InjectionStrategy.CONSTRUCTOR, collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
      componentModel = "spring")
public interface DocFileMapper extends GenericMapper<DocFile,DocFileDto>
{

}
