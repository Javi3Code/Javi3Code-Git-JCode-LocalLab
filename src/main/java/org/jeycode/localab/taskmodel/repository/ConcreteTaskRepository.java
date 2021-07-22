package org.jeycode.localab.taskmodel.repository;

import org.jeycode.localab.taskmodel.model.ConcreteTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcreteTaskRepository extends JpaRepository<ConcreteTask,String>
{

}
