package org.jeycode.localab.wrappermodel;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcreteTask
{

      @Id
      private String taskname;
      @Transient
      private boolean persist;
      @OneToOne(mappedBy = "taskFilesId", cascade = CascadeType.ALL)
      @JoinColumn
      private TaskFiles taskfiles;
}
