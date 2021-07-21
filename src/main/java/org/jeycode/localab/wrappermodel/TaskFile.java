package org.jeycode.localab.wrappermodel;

import java.util.List;

import javax.print.Doc;

import org.jeycode.localab.utils.YMLObj;
import org.jeycode.localab.wrappermodel.filemodel.Css;
import org.jeycode.localab.wrappermodel.filemodel.Html;
import org.jeycode.localab.wrappermodel.filemodel.Img;
import org.jeycode.localab.wrappermodel.filemodel.Js;

import lombok.Data;

@Data
public class TaskFile implements YMLObj
{

      private List<Html> html;
      private List<Css> css;
      private List<Js> js;
      private List<Img> img;
      private List<Doc> doc;

}
