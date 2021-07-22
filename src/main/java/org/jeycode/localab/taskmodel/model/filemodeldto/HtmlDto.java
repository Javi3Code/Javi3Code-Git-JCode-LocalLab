package org.jeycode.localab.taskmodel.model.filemodeldto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HtmlDto
{
      private String genericPath;
      private List<HtmlFilesDto> htmlFiles;
}
