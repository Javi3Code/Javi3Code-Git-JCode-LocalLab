package org.jeycode.localab.wrappermodel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
      @Transient
      private boolean persist;
      @OneToOne(mappedBy = "concreteTask", cascade = CascadeType.ALL)
      private TaskFiles taskfiles;
}
