package org.jeycode.localab.configmodel;

import java.util.List;

import org.jeycode.localab.configmodel.thememodel.Theme;
import org.jeycode.localab.wrappermodel.YMLObj;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class AppConfigObj implements YMLObj
{

      private List<String> workspaces;
      private OriginDir origin;
      private int commandsSessionStorage,age;
      private Theme theme;

}
