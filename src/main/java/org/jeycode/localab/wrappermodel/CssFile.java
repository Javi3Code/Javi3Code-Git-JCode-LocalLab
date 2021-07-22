package org.jeycode.localab.wrappermodel;

import javax.persistence.Entity;

import org.jeycode.localab.wrappermodel.filemodel.GenericFrontFile;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Entity
public class CssFile extends GenericFrontFile
{

}
