package org.jeycode.localab.view.component.panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommandMenuPanel extends JPanel
{

      public void init()
      {
            BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
            setLayout(layout);
            JButton comp = new JButton("btn1");
            JButton comp2 = new JButton("btn1");
            JButton comp3 = new JButton("btn1");
            JButton comp4 = new JButton("btn1");
            JButton comp5 = new JButton("btn1");
            JButton comp6 = new JButton("btn1");
            JButton comp7 = new JButton("btn1");
            JButton comp8 = new JButton("btn1");
            comp.setSize(300,100);
            add(comp);
            add(comp2);
            add(comp3);
            add(comp4);
            add(comp5);
            add(comp6);
            add(comp7);
            add(comp8);
      }

      private static final long serialVersionUID = 6326204796361780132L;

}
