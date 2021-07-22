package org.jeycode.localab.taskmodel.model.filemodeldto;

import java.util.List;

import org.jeycode.localab.utils.LocaleRef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HtmlFilesDto
{

      private LocaleRef localeRef = LocaleRef.ALL;
      private List<String> files;
}
