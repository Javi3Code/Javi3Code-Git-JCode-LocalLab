package org.jeycode.localab.taskmodel.model.dto;

import java.util.List;

import org.jeycode.localab.taskmodel.model.filemodeldto.CssFileDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.DocFileDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.HtmlDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.ImgFileDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.JsFileDto;

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
