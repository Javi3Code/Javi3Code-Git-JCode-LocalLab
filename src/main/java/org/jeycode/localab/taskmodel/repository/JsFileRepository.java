package org.jeycode.localab.taskmodel.repository;

import org.jeycode.localab.taskmodel.model.filemodel.JsFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsFileRepository extends JpaRepository<JsFile,Long>
{

}
