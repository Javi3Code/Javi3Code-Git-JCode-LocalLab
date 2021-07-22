package org.jeycode.localab.taskmodel.model.filemodel;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.jeycode.localab.taskmodel.model.filemodeldto.CssFileDto;
import org.jeycode.localab.taskmodel.model.mapper.CssFileMapper;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 
 * 
 * Entidad --> Archivos Css
 * 
 * @see GenericFrontFile
 * @see CssFileDto
 * @see CssFileMapper
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
@Table(name = "CSS_FILE")
public class CssFile extends GenericFrontFile
{

}
