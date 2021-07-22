package org.jeycode.localab.taskmodel.repository;

import org.jeycode.localab.taskmodel.model.filemodel.HtmlFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HtmlFileRepository extends JpaRepository<HtmlFile,Long>
{

}
