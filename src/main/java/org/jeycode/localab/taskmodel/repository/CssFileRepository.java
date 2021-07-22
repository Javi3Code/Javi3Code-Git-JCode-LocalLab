package org.jeycode.localab.taskmodel.repository;

import org.jeycode.localab.taskmodel.model.filemodel.CssFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CssFileRepository extends JpaRepository<CssFile,Long>
{
      
}
