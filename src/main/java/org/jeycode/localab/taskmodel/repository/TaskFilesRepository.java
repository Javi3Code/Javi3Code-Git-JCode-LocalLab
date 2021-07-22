package org.jeycode.localab.taskmodel.repository;

import org.jeycode.localab.taskmodel.model.TaskFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskFilesRepository extends JpaRepository<TaskFiles,Long>
{

}
