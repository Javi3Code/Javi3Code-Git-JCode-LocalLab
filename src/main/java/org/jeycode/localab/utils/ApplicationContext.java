package org.jeycode.localab.utils;

import org.jeycode.localab.configmodel.AppConfigObj;

import lombok.experimental.UtilityClass;

/**
 * 
 * En esta clase trataremos de tener referencia a un objeto realmente importante
 * del contexto de ejecución, pero que puede cambiar durante la ejecución o que
 * realmente es un objeto static y necesitamos referencia de él, por lo que no
 * lo creamos como un bean.
 * 
 * @author Javier Pérez Alonso
 *
 *         3 oct. 2021
 *
 */

@UtilityClass
public class ApplicationContext
{

      public static AppConfigObj applicationConfigObj;
}
