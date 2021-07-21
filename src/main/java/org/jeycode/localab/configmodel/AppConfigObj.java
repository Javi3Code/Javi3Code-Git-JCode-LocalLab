package org.jeycode.localab.configmodel;

import java.util.ArrayList;
import java.util.List;

import org.jeycode.localab.configmodel.thememodel.Theme;
import org.jeycode.localab.utils.YMLObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Clase Pojo que encapsula la configuración general de la aplicación.
 * 
 * @author Javier Pérez Alonso
 *
 *         21 jul. 2021
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppConfigObj implements YMLObj
{

      private List<String> workspaces = new ArrayList<>();
      private OriginDir origin = new OriginDir();
      private int commandsSessionStorage,age;
      private Theme theme = new Theme();

}
