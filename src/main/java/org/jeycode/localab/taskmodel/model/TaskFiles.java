package org.jeycode.localab.taskmodel.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.jeycode.localab.taskmodel.model.dto.TaskFilesDto;
import org.jeycode.localab.taskmodel.model.filemodel.CssFile;
import org.jeycode.localab.taskmodel.model.filemodel.DocFile;
import org.jeycode.localab.taskmodel.model.filemodel.GenericFrontFile;
import org.jeycode.localab.taskmodel.model.filemodel.Html;
import org.jeycode.localab.taskmodel.model.filemodel.ImgFile;
import org.jeycode.localab.taskmodel.model.filemodel.JsFile;
import org.jeycode.localab.taskmodel.model.mapper.TaskFilesMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Entidad que encapsula las listas de archivos vinculados a una
 * {@link ConcreteTask}.
 * 
 * @see TaskFilesDto
 * @see TaskFilesMapper
 * @see Html
 * @see GenericFrontFile
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
@Entity
public class TaskFiles
{

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
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
      private ConcreteTask concreteTask;

}
