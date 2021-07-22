package org.jeycode.localab.taskmodel.model.dto;

import org.jeycode.localab.taskmodel.model.YMLObj;

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
      private TaskFilesDto taskfiles;
      private String taskdescription;
}
