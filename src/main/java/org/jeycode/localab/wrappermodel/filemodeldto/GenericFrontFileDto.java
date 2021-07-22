package org.jeycode.localab.wrappermodel.filemodeldto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GenericFrontFileDto
{

      protected String genericPath;
      protected List<String> files;
}
