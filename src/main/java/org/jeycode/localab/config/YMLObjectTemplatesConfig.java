package org.jeycode.localab.config;

import static java.util.Arrays.asList;

import java.util.HashSet;

import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.configmodel.OriginDir;
import org.jeycode.localab.taskmodel.model.dto.ConcreteTaskDto;
import org.jeycode.localab.taskmodel.model.dto.TaskFilesDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.CssFileDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.DocFileDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.HtmlDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.HtmlFileDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.ImgFileDto;
import org.jeycode.localab.taskmodel.model.filemodeldto.JsFileDto;
import org.jeycode.localab.utils.LocaleRef;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 
 * En esta clase establecemos dos beans usados para la creación de los YML que
 * serviran de plantilla.
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         22 jul. 2021
 *
 */

@Configuration
public class YMLObjectTemplatesConfig
{

      @Bean @Scope("singleton")
      public AppConfigObj appConfigObjTemplate()
      {
            OriginDir originDir = OriginDir.builder()
                                           .repositoryDir("C://RepoDirSample")
                                           .htmlDir("/htmlDirSample")
                                           .cssDir("/cssDirSample")
                                           .jsDir("/jsDirSample")
                                           .imgDir("/imgDirSample")
                                           .docDir("/docDirSample")
                                           .build();

            return AppConfigObj.builder()
                               .workspaces(asList("C://SampleDir","C://OtherSampleWorkspace"))
                               .localeRefs(new HashSet<>(asList(LocaleRef.es_ES,LocaleRef.en_US)))
                               .origin(originDir)
                               .commandsSessionStorage(10)
                               .age(3600)
                               .build();
      }

      @Bean @Scope("singleton")
      public ConcreteTaskDto concreteTaskObjTemplate()
      {
            HtmlFileDto htmlFilesOne = new HtmlFileDto(LocaleRef.es_ES,asList("htmlSample.html","htmlSample2.html"));
            HtmlFileDto htmlFilesTwo = new HtmlFileDto(LocaleRef.ALL,asList("htmlSample.html","htmlSample2.html"));

            HtmlDto html = new HtmlDto("/htmlSampleSubDir",asList(htmlFilesOne,htmlFilesTwo));
            CssFileDto css = CssFileDto.builder()
                                       .genericPath("/cssSampleSubDir")
                                       .files(asList("cssfilesample.css"))
                                       .build();

            JsFileDto js = JsFileDto.builder()
                                    .genericPath("/jsSampleSubDir")
                                    .files(asList("jsfilesample.js"))
                                    .build();

            ImgFileDto img = ImgFileDto.builder()
                                       .genericPath("/imgSampleSubDir")
                                       .files(asList("imgfilesample.svg"))
                                       .build();

            DocFileDto doc = DocFileDto.builder()
                                       .genericPath("/docSampleSubDir")
                                       .files(asList("docfilesample.pdf"))
                                       .build();

            TaskFilesDto taskfile = TaskFilesDto.builder()
                                                .html(asList(html))
                                                .js(asList(js))
                                                .css(asList(css))
                                                .img(asList(img))
                                                .doc(asList(doc))
                                                .build();

            return new ConcreteTaskDto("WP-SampleTask",
                                       "Este fichero es un ejemplo de como debe ser un task.yml, puede y debe reutilizarse.",taskfile);
      }

}
