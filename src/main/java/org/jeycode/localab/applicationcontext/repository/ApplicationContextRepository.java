package org.jeycode.localab.applicationcontext.repository;

import org.jeycode.localab.applicationcontext.model.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationContextRepository extends JpaRepository<ApplicationContext,Long>
{

}
