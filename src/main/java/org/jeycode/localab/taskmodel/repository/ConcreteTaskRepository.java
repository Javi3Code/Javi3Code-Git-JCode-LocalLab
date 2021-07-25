package org.jeycode.localab.taskmodel.repository;

import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Implementación de {@link JpaRepository} para el acceso a datos de
 * {@link ConcreteTaskDto}.
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Repository
public interface ConcreteTaskRepository extends JpaRepository<ConcreteTask,String>
{

//      Optional<ConcreteTask> find

} 
