package org.jeycode.localab.wrappermodel.dto;

import java.util.List;

import org.jeycode.localab.wrappermodel.filemodeldto.CssFileDto;
import org.jeycode.localab.wrappermodel.filemodeldto.DocFileDto;
import org.jeycode.localab.wrappermodel.filemodeldto.HtmlDto;
import org.jeycode.localab.wrappermodel.filemodeldto.ImgFileDto;
import org.jeycode.localab.wrappermodel.filemodeldto.JsFileDto;

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
      private List<CssFileDto> css;
      private List<JsFileDto> js;
      private List<ImgFileDto> img;
      private List<DocFileDto> doc;

}
