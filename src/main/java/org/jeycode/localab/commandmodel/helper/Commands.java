package org.jeycode.localab.commandmodel.helper;

/**
 * 
 * Helper dónde se definen los comandos.
 * 
 * 
 * @author Javier Pérez Alonso
 *
 *         11 ago. 2021
 *
 */
public interface Commands
{

      /*
       * Apagar la app
       */
      String CLOSE = "bye";
      /*
       * Dormir/Ocultar la app
       */
      String SLEEP = "hide";

      /*
       * Limpiar la ventana de logs si está abierta.
       */
      String CLEAR = "clear";
      /*
       * Mostrar ayuda - commandlist
       */
      String HELP = "help";
      /*
       * Desplegar la ventan de logs.
       */
      String OPEN_LOG_WINDOW = "oplg";
      /*
       * Relacionado a configuración y ficheros _config.yml
       */
      String CONFIG = "cfg";
      /*
       * Obtener del repositorio.
       */
      String GET = "get";
      /*
       * Pushear al repositorio.
       */
      String PUSH = "push";
      /*
       * Crear un TaskModelDir
       */
      String CREATE = "cr";
      /*
       * Borrar un TaskModelDir físico o uno o más taskfile de bbdd
       */
      String DELETE = "del";
      /*
       * Guardar uno o más taskfile en bbdd
       * 
       */
      String SAVE_TF = "sv";
      /*
       * Actualizar uno o más taskfile de bbdd
       */
      String UPDATE_TF = "updt";
      /*
       * Mostrar en ventana de logs el contenido de un taskfile
       */
      String SHOW_TF = "show";
      /*
       * Buscar y mostrar uno o más taskfile
       */
      String FIND = "find";
      /*
       * Exportar un fichero con ejemplos de taskfile, config ocon el listado de
       * comandos
       */
      String EXPORT = "exp";

}
