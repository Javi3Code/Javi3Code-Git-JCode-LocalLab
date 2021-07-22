package org.jeycode.localab.taskmodel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConcreteTask
{

      @Id
      private String taskname;
      @OneToOne(mappedBy = "concreteTask", cascade = CascadeType.ALL)
      private TaskFiles taskfiles;
      private String taskdescription;
}
