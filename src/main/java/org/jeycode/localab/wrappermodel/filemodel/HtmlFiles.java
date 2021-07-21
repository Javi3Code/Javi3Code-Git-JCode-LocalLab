package org.jeycode.localab.wrappermodel.filemodel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jeycode.localab.utils.LocaleRef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HtmlFiles
{

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long htmlFilesId;
      @Enumerated(EnumType.STRING)
      @Column(nullable = false)
      private LocaleRef localeRef = LocaleRef.ALL;
      @ElementCollection(fetch = FetchType.EAGER)
      private List<String> files;

}
