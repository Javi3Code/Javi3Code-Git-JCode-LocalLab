package org.jeycode.localab.wrappermodel.filemodel;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GenericFrontFile
{

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long fileId;
      private String genericPath;
      @ElementCollection
      private List<String> files;
}
