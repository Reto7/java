package ch.ibw.swing;

import java.awt.*;
import javax.swing.*;
public class NotenEingabe extends JFrame {
  Container c;          
  public NotenEingabe() {
    c = getContentPane();
    c.setLayout(new GridLayout(5, 1));
    c.add(new JCheckBox("sehr gut"));
    c.add(new JCheckBox("gut"));
    c.add(new JCheckBox("befriedigend"));
    c.add(new JCheckBox("ausreichend", true));
    c.add(new JCheckBox("ungenuegend"));
  }
}
