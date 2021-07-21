package org.jeycode.localab.configmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Clase que encapsula los path a los directorios de origen de cada tipo de
 * archivo.
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         21 jul. 2021
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OriginDir
{

      private String repositoryDir,cssDir,jsDir,htmlDir,imgDir,docDir;
}
