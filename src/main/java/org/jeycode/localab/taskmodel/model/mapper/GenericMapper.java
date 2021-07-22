package org.jeycode.localab.taskmodel.model.mapper;

public interface GenericMapper<Entity,Dto>
{

      Entity reverse(Dto dto);

      Dto toDto(Entity entity);
}
