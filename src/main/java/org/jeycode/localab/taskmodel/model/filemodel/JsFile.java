package org.jeycode.localab.taskmodel.model.filemodel;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "JS_FILE")
public class JsFile extends GenericFrontFile
{

}
