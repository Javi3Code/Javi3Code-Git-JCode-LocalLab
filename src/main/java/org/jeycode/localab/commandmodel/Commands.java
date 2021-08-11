package org.jeycode.localab.commandmodel;

public final class Commands
{

      /*
       * Apagar la app
       */
      public static String CLOSE = "bye";
      /*
       * Dormir/Ocultar la app
       */
      public static String SLEEP = "hide";

      /*
       * Limpiar la ventana de logs si está abierta.
       */
      public static String CLEAR = "clear";
      /*
       * Mostrar ayuda - commandlist
       */
      public static String HELP = "help";
      /*
       * Desplegar la ventan de logs.
       */
      public static String OPEN_LOG_WINDOW = "oplg";
      /*
       * Relacionado a configuración y ficheros _config.yml
       */
      public static String CONFIG = "cfg";
      /*
       * Obtener del repositorio.
       */
      public static String GET = "get";
      /*
       * Pushear al repositorio.
       */
      public static String PUSH = "push";
      /*
       * Crear un TaskModelDir
       */
      public static String CREATE = "cr";
      /*
       * Borrar un TaskModelDir físico o uno o más taskfile de bbdd
       */
      public static String DELETE = "del";
      /*
       * Guardar uno o más taskfile en bbdd
       * 
       */
      public static String SAVE_TF = "sv";
      /*
       * Actualizar uno o más taskfile de bbdd
       */
      public static String UPDATE_TF = "updt";
      /*
       * Mostrar en ventana de logs el contenido de un taskfile
       */
      public static String SHOW_TF = "show";
      /*
       * Buscar y mostrar uno o más taskfile
       */
      public static String FIND = "find";
      /*
       * Exportar un fichero con ejemplos de taskfile, config ocon el listado de
       * comandos
       */
      public static String EXPORT = "exp";

}
