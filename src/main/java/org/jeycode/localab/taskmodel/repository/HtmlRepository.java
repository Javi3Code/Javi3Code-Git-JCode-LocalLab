package org.jeycode.localab.taskmodel.repository;

import org.jeycode.localab.taskmodel.model.filemodel.Html;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HtmlRepository extends JpaRepository<Html,Long>
{

}
