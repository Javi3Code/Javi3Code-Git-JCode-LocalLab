package org.jeycode.localab.applicationcontext.model;

import org.jeycode.localab.configmodel.OriginDir;
import org.jeycode.localab.configmodel.Workspace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         3 oct. 2021
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicationContext
{

      private OriginDir activeOrigin;
      private Workspace activeWorkspace;
      private String activeFlatTheme;
}
