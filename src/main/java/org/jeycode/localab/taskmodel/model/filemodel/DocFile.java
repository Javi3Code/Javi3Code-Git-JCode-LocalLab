package org.jeycode.localab.taskmodel.model.filemodel;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.jeycode.localab.taskmodel.model.filemodeldto.DocFileDto;
import org.jeycode.localab.taskmodel.model.mapper.DocFileMapper;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 
 * 
 * Entidad --> Archivos Doc
 * 
 * @see GenericFrontFile
 * @see DocFileDto
 * @see DocFileMapper
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
@Table(name = "DOC_FILE")
public class DocFile extends GenericFrontFile
{

}
