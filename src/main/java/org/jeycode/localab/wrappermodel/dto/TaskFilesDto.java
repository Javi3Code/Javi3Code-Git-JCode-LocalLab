package org.jeycode.localab.wrappermodel.dto;

import java.util.List;

import org.jeycode.localab.wrappermodel.filemodeldto.GenericFrontFileDto;
import org.jeycode.localab.wrappermodel.filemodeldto.HtmlDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskFilesDto
{

      private List<HtmlDto> html;
      private List<GenericFrontFileDto> css;
      private List<GenericFrontFileDto> js;
      private List<GenericFrontFileDto> img;
      private List<GenericFrontFileDto> doc;

}
