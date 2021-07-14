package org.jeycode.localab.wrappermodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcreteTask
{

      private String taskname;
      private boolean persist;
      private List<TaskFile> taskfiles;
}
