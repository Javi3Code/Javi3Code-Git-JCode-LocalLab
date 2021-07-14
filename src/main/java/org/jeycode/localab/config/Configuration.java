package org.jeycode.localab.config;

import java.util.ArrayList;
import java.util.List;

import org.jeycode.localab.config.theme.Theme;
import org.jeycode.localab.utils.YMLObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Configuration implements YMLObj
{

      private List<String> workspaces = new ArrayList<>();
      private OriginDir origin = new OriginDir();
      private int commandsSessionStorage,age;
      private Theme theme = new Theme();

}
