package org.jeycode.localab.taskmodel.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.dto.TaskFilesDto;
import org.jeycode.localab.taskmodel.model.filemodel.CssFile;
import org.jeycode.localab.taskmodel.model.filemodel.DocFile;
import org.jeycode.localab.taskmodel.model.filemodel.Html;
import org.jeycode.localab.taskmodel.model.filemodel.ImgFile;
import org.jeycode.localab.taskmodel.model.filemodel.JsFile;
import org.jeycode.localab.taskmodel.model.mapper.TaskFilesMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * Entidad que encapsula las listas de archivos vinculados a una
 * {@link ConcreteTaskDto}.
 * 
 * @see TaskFilesDto
 * @see TaskFilesMapper
 * @see Html
 * 
 * @author Javier Pérez Alonso
 *
 *         21 jul. 2021
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"concreteTask"})
@Entity
@Table(name = "TASK_FILES")
public class TaskFiles
{

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long taskFilesId;
      @OneToMany(mappedBy = "taskFiles", orphanRemoval = true, cascade = CascadeType.ALL)
      private List<Html> html;
      @OneToMany(mappedBy = "taskFiles", orphanRemoval = true, cascade = CascadeType.ALL)
      private List<CssFile> css;
      @OneToMany(mappedBy = "taskFiles", orphanRemoval = true, cascade = CascadeType.ALL)
      private List<JsFile> js;
      @OneToMany(mappedBy = "taskFiles", orphanRemoval = true, cascade = CascadeType.ALL)
      private List<ImgFile> img;
      @OneToMany(mappedBy = "taskFiles", orphanRemoval = true, cascade = CascadeType.ALL)
      private List<DocFile> doc;
      @OneToOne
      @JoinColumn(name = "taskName")
      private ConcreteTask concreteTask;

}
