package org.jeycode.localab.taskmodel.model.filemodel;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Entity
public class DocFile extends GenericFrontFile
{

}
