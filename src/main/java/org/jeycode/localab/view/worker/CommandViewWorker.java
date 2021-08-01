package org.jeycode.localab.view.worker;

import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

/**
 * 
 * BackgroundWorker que va a ejecutar las tareas sin interferir con el EDT.
 * 
 * @see SwingWorker
 * 
 * @author Javier Pérez Alonso
 *
 *         24 jul. 2021
 *
 */

@AllArgsConstructor
@Component
public class CommandViewWorker extends SwingWorker<String,String>
{

      private final JTextArea areaTxt;

      @Override
      protected String doInBackground() throws Exception
      {
            return null;
      }

      @Override
      protected void process(List<String> chunks)
      {}

      @Override
      protected void done()
      {}
}
