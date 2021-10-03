package org.jeycode.localab.commandmodel.helper;

import java.util.concurrent.CompletableFuture;

import javax.swing.JFrame;

import static org.jeycode.localab.utils.ApplicationContext.*;
import org.jeycode.localab.commandmodel.executable.Executable;
import org.jeycode.localab.view.component.AppPrincipalWindow;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Executables
{

      public static Executable closeApp(AppPrincipalWindow appPrincipalWindow)
      {
            return (arg0,arg1)->
                  {
                        System.exit(0);
                        return null;
                  };
      }

      public static Executable sleepApp(AppPrincipalWindow appPrincipalWindow)
      {
            return (arg0,arg1)-> null;
      }

}
