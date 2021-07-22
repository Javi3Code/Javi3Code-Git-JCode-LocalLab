package org.jeycode.localab.taskmodel.repository;

import org.jeycode.localab.taskmodel.model.filemodel.DocFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends JpaRepository<DocFile,Long>
{

}
