package org.jeycode.localab.wrappermodel.dto;

import org.jeycode.localab.wrappermodel.YMLObj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConcreteTaskDto implements YMLObj
{

      private String taskname;
      private boolean persist;
      private TaskFilesDto taskfiles;
}
