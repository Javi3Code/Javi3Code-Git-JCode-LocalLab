package org.jeycode.localab.wrappermodel.mapper;

public interface GenericMapper<Entity,Dto>
{

      Entity reverse(Dto dto);

      Dto toDto(Entity entity);
}
