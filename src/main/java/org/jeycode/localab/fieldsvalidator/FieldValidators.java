package org.jeycode.localab.fieldsvalidator;

import static java.util.stream.Collectors.joining;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jeycode.localab.taskmodel.err.TaskFieldsException;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class FieldValidators
{

      private final Validator fieldValidator;

      @Before(value = "execution(* org.jeycode.localab.taskmodel.controller.ConcreteTaskController.addOne(..))", argNames = "concTaskDto")
      public void validateAddConcreteTaskDto(JoinPoint joinPoint)
      {
            validateFields(joinPoint);
      }

      @Before(value = "execution(* org.jeycode.localab.taskmodel.controller.ConcreteTaskController.updateOne(..))",
            argNames = "concTaskDto")
      public void validateUpdateConcreteTaskDto(JoinPoint joinPoint)
      {
            validateFields(joinPoint);
      }

      @Before(value = "execution(* org.jeycode.localab.taskmodel.controller.ConcreteTaskController.deleteOne(..))",
            argNames = "concTaskDto")
      public void validateDeleteConcreteTaskDto(JoinPoint joinPoint)
      {
            validateFields(joinPoint);
      }

      @Before(value = "execution(* org.jeycode.localab.taskmodel.controller.ConcreteTaskController.addAll(..))", argNames = "concTaskDtos")
      public void validateAddConcreteTaskDtos(JoinPoint joinPoint)
      {
            validateSetField(joinPoint);

      }

      @Before(value = "execution(* org.jeycode.localab.taskmodel.controller.ConcreteTaskController.updateAll(..))",
            argNames = "concTaskDtos")
      public void validateUpdateConcreteTaskDtos(JoinPoint joinPoint)
      {
            validateSetField(joinPoint);

      }

      /*
       * 
       * PRIVATE METHODS
       * 
       */

      private void validateFields(JoinPoint joinPoint)
      {
            ConcreteTaskDto concreteTaskDto = (ConcreteTaskDto)joinPoint.getArgs()[0];
            Set<ConstraintViolation<@Valid ConcreteTaskDto>> constraints = fieldValidator.validate(concreteTaskDto,Default.class);
            if (!constraints.isEmpty())
            {
                  putLogErr(concreteTaskDto);
                  throw new TaskFieldsException(constraints.stream()
                                                           .map(ConstraintViolation::getMessage)
                                                           .collect(joining("\n")));
            }
      }

      private void validateSetField(JoinPoint joinPoint)
      {
            @SuppressWarnings("unchecked")
            Set<? extends ConcreteTaskDto> setOfConcreteTaskDto = (Set<ConcreteTaskDto>)joinPoint.getArgs()[0];
            setOfConcreteTaskDto.forEach(concTaskDto->
                  {
                        Set<ConstraintViolation<ConcreteTaskDto>> constraints = fieldValidator.validate((ConcreteTaskDto)setOfConcreteTaskDto,
                                                                                                        Default.class);

                        if (!constraints.isEmpty())
                        {
                              putLogErr(concTaskDto);
                              throw new TaskFieldsException(constraints.stream()
                                                                       .map(constraint->
                                                                             {
                                                                                   String messageFormatted = formatTaskNameForErrMessage(concTaskDto);
                                                                                   return String.join(" :: ",messageFormatted,
                                                                                                      constraint.getMessage());
                                                                             })
                                                                       .collect(joining("\n")));
                        }
                  });
      }

      private void putLogErr(ConcreteTaskDto concreteTaskDto)
      {
            log.error(formatTaskNameForErrMessage(concreteTaskDto) + " :: "
                                    + "Errores de formato *_task.yml, al mapearlo a objeto, alguno de los argumentos no siguen el patrón válido.");
      }

      private String formatTaskNameForErrMessage(ConcreteTaskDto concTaskDto)
      {
            String messageFormatted = "Nombre del task [" + concTaskDto.getTaskname() + "]";
            return messageFormatted;
      }
}
