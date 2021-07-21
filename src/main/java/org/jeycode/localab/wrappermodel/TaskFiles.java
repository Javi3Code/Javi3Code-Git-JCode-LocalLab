package org.jeycode.localab.wrappermodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.jeycode.localab.wrappermodel.filemodel.GenericFrontFile;
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
public class TaskFiles
{

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long taskFilesId;
      @OneToMany(mappedBy = "htmlId", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
      @JoinColumn
      private List<Html> html;
      @ElementCollection(fetch = FetchType.EAGER)
      private List<GenericFrontFile> css;
      @ElementCollection(fetch = FetchType.EAGER)
      private List<GenericFrontFile> js;
      @ElementCollection(fetch = FetchType.EAGER)
      private List<GenericFrontFile> img;
      @ElementCollection(fetch = FetchType.EAGER)
      private List<GenericFrontFile> doc;

}
