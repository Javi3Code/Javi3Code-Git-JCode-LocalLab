package org.jeycode.localab.wrappermodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.jeycode.localab.wrappermodel.filemodel.GenericFrontFile;
import org.jeycode.localab.wrappermodel.filemodel.Html;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
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
      @ElementCollection
      @Default
      @Column(name = "css")
      private List<GenericFrontFile> css = new ArrayList<GenericFrontFile>();
      @ElementCollection
      @Default
      @Column(name = "js")
      private List<GenericFrontFile> js = new ArrayList<GenericFrontFile>();
      @ElementCollection
      @Default
      @Column(name = "img")
      private List<GenericFrontFile> img = new ArrayList<GenericFrontFile>();
      @ElementCollection
      @Default
      @Column(name = "doc")
      private List<GenericFrontFile> doc = new ArrayList<GenericFrontFile>();
      @OneToOne
      private ConcreteTask concreteTask;

}
