package org.jeycode.localab.taskmodel.model.filemodel;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeycode.localab.taskmodel.model.filemodeldto.HtmlFileDto;
import org.jeycode.localab.taskmodel.model.mapper.HtmlFilesMapper;
import org.jeycode.localab.utils.LocaleRef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Entidad que encapsula los datos relacionados a los ficheros html.
 * 
 * @see HtmlFileDto
 * @see HtmlFilesMapper
 * @see LocaleRef
 * @see Html
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HTML_FILE")
public class HtmlFile
{

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long htmlFilesId;
      @Enumerated(EnumType.STRING)
      @Column(nullable = false)
      private LocaleRef localeRef = LocaleRef.ALL;
      @ElementCollection(fetch = FetchType.EAGER)
      @CollectionTable(name = "HTML_Lst_FILES")
      private List<String> files;
      @ManyToOne
      @JoinColumn(name = "htmlId")
      private Html htmlObj;

}
