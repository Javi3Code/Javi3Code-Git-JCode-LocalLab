package org.jeycode.localab.taskmodel.service;

import java.util.List;
import java.util.function.Predicate;

public interface GenericService<Entity,Id>
{

      List<Entity> findAll();

      Entity findById(Id id);

      Entity findOneIf(Predicate<?> is);

      boolean deleteAll();

      Entity addOne(Entity entity);

      Entity updateOne(Entity entity);

      boolean deleteOne(Entity entity);

      Entity updateAll(Entity entity);

}
