package org.jeycode.localab.view.component.panel;

import java.awt.Color;

import javax.swing.JPanel;

import org.jeycode.localab.view.component.VisualInfoArea;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PrincipalPanel extends JPanel
{

      @Getter
      private final VisualInfoArea infoArea;
      @Getter
      private final CommandMenuPanel commandMenuPanel;

      public void init()
      {
            setBackground(Color.gray);
            setLayout(null);
            add(commandMenuPanel);
            commandMenuPanel.setSize(this.getWidth() / 8,this.getHeight());
            commandMenuPanel.setLocation(0,0);
            commandMenuPanel.init();
      }

      private static final long serialVersionUID = 1L;

}
