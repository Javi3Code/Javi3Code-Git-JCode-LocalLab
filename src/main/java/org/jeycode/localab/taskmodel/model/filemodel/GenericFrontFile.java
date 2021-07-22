package org.jeycode.localab.taskmodel.model.filemodel;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.jeycode.localab.taskmodel.model.TaskFiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GenericFrontFile
{

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      protected long fileId;
      protected String genericPath;
      @ElementCollection
      @CollectionTable(name = "FILES")
      protected List<String> files;
      @ManyToOne
      protected TaskFiles taskFiles;
}
