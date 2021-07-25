package org.jeycode.localab.taskmodel.model.filemodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jeycode.localab.taskmodel.model.TaskFiles;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.HtmlDto;
import org.jeycode.localab.taskmodel.model.mapper.HtmlMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * Entidad que encapsula los datos relacionados a los archivos HTMl de la
 * {@link ConcreteTaskDto} en cuestión.
 * 
 * @see HtmlDto
 * @see HtmlMapper
 * @see HtmlFile
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"taskFiles"})
@Entity
@Table(name = "HTML")
public class Html
{

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long htmlId;
      private String genericPath;
      @OneToMany(cascade = CascadeType.ALL, mappedBy = "htmlObj", orphanRemoval = true, fetch = FetchType.EAGER)
      private List<HtmlFile> htmlFiles;
      @ManyToOne
      @JoinColumn(name = "taskFilesId")
      private TaskFiles taskFiles;

}
