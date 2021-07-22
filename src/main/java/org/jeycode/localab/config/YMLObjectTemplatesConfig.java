package org.jeycode.localab.config;

import java.util.List;

import org.jeycode.localab.configmodel.AppConfigObj;
import org.jeycode.localab.configmodel.OriginDir;
import org.jeycode.localab.configmodel.thememodel.AppColor;
import org.jeycode.localab.configmodel.thememodel.Theme;
import org.jeycode.localab.utils.LocaleRef;
import org.jeycode.localab.wrappermodel.dto.ConcreteTaskDto;
import org.jeycode.localab.wrappermodel.dto.TaskFilesDto;
import org.jeycode.localab.wrappermodel.filemodeldto.CssFileDto;
import org.jeycode.localab.wrappermodel.filemodeldto.DocFileDto;
import org.jeycode.localab.wrappermodel.filemodeldto.HtmlDto;
import org.jeycode.localab.wrappermodel.filemodeldto.HtmlFilesDto;
import org.jeycode.localab.wrappermodel.filemodeldto.ImgFileDto;
import org.jeycode.localab.wrappermodel.filemodeldto.JsFileDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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

            AppColor fgColor = AppColor.builder()
                                       .hex("#212F3D")
                                       .build();

            AppColor bgColor = AppColor.builder()
                                       .r(10)
                                       .g(10)
                                       .b(10)
                                       .a(0.5f)
                                       .build();

            return AppConfigObj.builder()
                               .workspaces(List.of("C://SampleDir","C://OtherSampleWorkspace"))
                               .origin(originDir)
                               .commandsSessionStorage(10)
                               .age(3600)
                               .theme(new Theme(bgColor,fgColor))
                               .build();
      }

      @Bean @Scope("singleton")
      public ConcreteTaskDto concreteTaskObjTemplate()
      {
            HtmlFilesDto htmlFilesOne = new HtmlFilesDto(LocaleRef.es_ES,List.of("htmlSample.html","htmlSample2.html"));
            HtmlFilesDto htmlFilesTwo = new HtmlFilesDto(LocaleRef.ALL,List.of("htmlSample.html","htmlSample2.html"));

            HtmlDto html = new HtmlDto("/htmlSampleSubDir",List.of(htmlFilesOne,htmlFilesTwo));
            CssFileDto css = CssFileDto.builder()
                                       .genericPath("/cssSampleSubDir")
                                       .files(List.of("cssfilesample.css"))
                                       .build();

            JsFileDto js = JsFileDto.builder()
                                    .genericPath("/jsSampleSubDir")
                                    .files(List.of("jsfilesample.js"))
                                    .build();

            ImgFileDto img = ImgFileDto.builder()
                                       .genericPath("/imgSampleSubDir")
                                       .files(List.of("imgfilesample.svg"))
                                       .build();

            DocFileDto doc = DocFileDto.builder()
                                       .genericPath("/docSampleSubDir")
                                       .files(List.of("docfilesample.pdf"))
                                       .build();

            TaskFilesDto taskfile = TaskFilesDto.builder()
                                                .html(List.of(html))
                                                .js(List.of(js))
                                                .css(List.of(css))
                                                .img(List.of(img))
                                                .doc(List.of(doc))
                                                .build();

            return new ConcreteTaskDto("WP-SampleTask",taskfile);
      }

}
