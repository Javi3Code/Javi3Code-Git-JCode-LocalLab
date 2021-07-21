package org.jeycode.localab.loader;

import static org.jeycode.localab.loader.GenericFileMapper.TASKFILEMAPPER;

import org.jeycode.localab.utils.YMLObj;
import org.jeycode.localab.wrappermodel.TaskFile;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * 
 * * Clase para cargar YML de cierta tarea. Implementa {@link GenericFileMapper}
 * Establece la clase a mapear.
 * 
 * @see TaskFile
 * 
 * @author Javier Pérez Alonso
 *
 *         21 jul. 2021
 *
 */

@RequiredArgsConstructor
@Component(TASKFILEMAPPER)
public class TaskFileMapper implements GenericFileMapper<TaskFile>
{

      @Override
      public Class<? extends YMLObj> getClassObjToReturn()
      {
            return TaskFile.class;
      }

}
