package org.jeycode.localab.taskmodel.model.filemodel;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeycode.localab.taskmodel.model.TaskFiles;
import org.jeycode.localab.taskmodel.model.filemodeldto.ImgFileDto;
import org.jeycode.localab.taskmodel.model.mapper.ImgFileMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * 
 * Entidad --> Archivos Img
 * 
 * @see ImgFileDto
 * @see ImgFileMapper
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"taskFiles"})
@Builder
@Entity
@Table(name = "IMG_FILE")
public class ImgFile
{

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long fileId;
      private String genericPath;
      @ElementCollection
      @CollectionTable(name = "IMG_FILES")
      private List<String> files;
      @ManyToOne
      private TaskFiles taskFiles;
}
