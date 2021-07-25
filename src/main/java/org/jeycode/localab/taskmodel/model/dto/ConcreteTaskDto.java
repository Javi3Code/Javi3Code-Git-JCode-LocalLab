package org.jeycode.localab.taskmodel.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.jeycode.localab.taskmodel.model.YMLObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ConcreteTaskDto implements YMLObj
{

      @NotBlank(message = "El nombre del *_task.yml no puede ser Null y debe contener al menos un carácter que no sea whitespace.")
      protected String taskname;
      @NotBlank(
            message = "La descripción no puede ser Null y debe contener al menos un carácter que no sea whitespace. Trata de que sea info sobre el contenido del task o el fin de agrupar estos archivos.")
      protected String taskdescription;
      @NotNull(message = "El task debe contener su taskfiles con todos los contenidos, revise el archivo *_task.yml")
      protected TaskFilesDto taskFiles;

}
