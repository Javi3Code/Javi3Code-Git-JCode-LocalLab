package org.jeycode.localab.taskmodel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
public class ConcreteTask
{

      @Id
      private String taskname;
      @OneToOne(mappedBy = "concreteTask", cascade = CascadeType.ALL)
      private TaskFiles taskfiles;
      private String taskdescription;
}
