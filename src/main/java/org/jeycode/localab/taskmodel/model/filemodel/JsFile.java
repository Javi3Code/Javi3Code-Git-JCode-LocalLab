package org.jeycode.localab.taskmodel.model.filemodel;

import javax.persistence.Entity;

import org.jeycode.localab.taskmodel.model.filemodeldto.JsFileDto;
import org.jeycode.localab.taskmodel.model.mapper.JsFileMapper;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 
 * 
 * Entidad --> Archivos js
 * 
 * @see GenericFrontFile
 * @see JsFileDto
 * @see JsFileMapper
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Entity
public class JsFile extends GenericFrontFile
{

}
