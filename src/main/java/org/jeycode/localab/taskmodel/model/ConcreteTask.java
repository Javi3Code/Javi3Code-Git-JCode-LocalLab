package org.jeycode.localab.taskmodel.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.mapper.ConcreteTaskMapper;
import org.jeycode.localab.taskmodel.repository.ConcreteTaskRepository;
import org.jeycode.localab.taskmodel.service.serviceimpl.ConcreteTaskAccessServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * Entidad que encapsula todos los datos necesarios vinculados a una "tarea".
 * 
 * @see ConcreteTaskDto
 * @see ConcreteTaskMapper
 * @see ConcreteTaskRepository
 * @see ConcreteTaskAccessServiceImpl
 * @see TaskFiles
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONCRETE_TASK")
public class ConcreteTask implements Serializable
{

      /**
       * 
       */
      private static final long serialVersionUID = 1L;
      @Id
      private String taskname;
      private String taskdescription;
      private LocalDate creationDate;
      @UpdateTimestamp
      private LocalDateTime lastUpdate;
      @OneToOne(mappedBy = "concreteTask", cascade = CascadeType.ALL, optional = false, orphanRemoval = true, fetch = FetchType.EAGER)
      private TaskFiles taskFiles;
}
