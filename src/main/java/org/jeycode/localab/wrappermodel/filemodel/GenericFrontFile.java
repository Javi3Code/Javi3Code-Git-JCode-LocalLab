package org.jeycode.localab.wrappermodel.filemodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericFrontFile
{

      private String genericPath;
      private List<String> files;
}