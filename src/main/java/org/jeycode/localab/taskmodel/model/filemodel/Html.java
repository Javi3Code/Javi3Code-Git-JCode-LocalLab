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

import org.jeycode.localab.taskmodel.model.TaskFiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Html
{

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long htmlId;
      private String genericPath;
      @OneToMany(cascade = CascadeType.ALL, mappedBy = "htmlObj", orphanRemoval = true, fetch = FetchType.EAGER)
      private List<HtmlFiles> htmlFiles;
      @ManyToOne
      @JoinColumn(name = "taskFilesId")
      private TaskFiles taskFiles;

}
