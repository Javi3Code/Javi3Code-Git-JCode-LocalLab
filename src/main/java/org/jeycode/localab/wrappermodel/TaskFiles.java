package org.jeycode.localab.wrappermodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.jeycode.localab.wrappermodel.filemodel.Html;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
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
