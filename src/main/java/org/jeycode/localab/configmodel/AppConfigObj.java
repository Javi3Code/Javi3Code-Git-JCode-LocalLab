package org.jeycode.localab.configmodel;

import java.util.List;

import org.jeycode.localab.taskmodel.model.YMLObj;

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

      private String theme;
      private int workspace;
      private int origin;
      private List<Workspace> workspaces;
      private List<OriginDir> origins;
}
