package org.jeycode.localab.taskmodel.model.filemodel;

import javax.persistence.Entity;

import org.jeycode.localab.taskmodel.model.filemodeldto.ImgFileDto;
import org.jeycode.localab.taskmodel.model.mapper.ImgFileMapper;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 
 * 
 * Entidad --> Archivos Img
 * 
 * @see GenericFrontFile
 * @see ImgFileDto
 * @see ImgFileMapper
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
public class ImgFile extends GenericFrontFile
{

}
