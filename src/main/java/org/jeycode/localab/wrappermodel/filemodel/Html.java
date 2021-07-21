package org.jeycode.localab.wrappermodel.filemodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Html
{

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long htmlId;
      private String genericPath;
      @JoinColumn
      @OneToOne(cascade = CascadeType.ALL, mappedBy = "htmlFileId", optional = false, orphanRemoval = true, fetch = FetchType.EAGER)
      private List<HtmlFiles> htmlFiles;
}
