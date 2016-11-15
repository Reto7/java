package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein Swing-Fenster mit CheckBoxes */
public class FrameMitCheckBoxes extends JFrame {
  Container c;            // Container dieses Frames
  // Feld fuer Check-Boxes, die im Frame erscheinen sollen
  JCheckBox cb[] = new JCheckBox[4];
  
  public FrameMitCheckBoxes() {  // Konstruktor
    c = getContentPane();             // Container bestimmen
    c.setLayout(new FlowLayout());    // Layout setzen
    
    // Erzeuge die Button-Objekte
    for (int i = 0; i < 4; i++)
      cb[i] = new JCheckBox("Box " + (i+1));
    cb[0].setSelected(true);
    cb[2].setSelected(true);
    
    // Fuege die Buttons dem Frame hinzu
    for (int i = 0; i < 4; i++) {
      c.add(cb[i]);
    }
  }
  public static void main(String[] args) {
    FrameMitCheckBoxes fenster = new FrameMitCheckBoxes();
    fenster.setTitle("Frame mit CheckBoxes");
    fenster.setSize(280,60);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
