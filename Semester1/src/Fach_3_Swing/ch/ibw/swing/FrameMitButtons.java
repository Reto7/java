package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein Swing-Fenster mit Buttons */
public class FrameMitButtons extends JFrame {
  Container c;            // Container dieses Frames
  // Feld fuer Buttons, die im Frame erscheinen sollen
  JButton b[] = new JButton[4];
  
  public FrameMitButtons() {    // Konstruktor
    c = getContentPane();             // Container bestimmen
    c.setLayout(new FlowLayout());    // Layout setzen
    
    // Erzeuge die Button-Objekte
    for (int i = 0; i < 4; i++) {
      b[i] = new JButton("Taste " + (i+1));
      b[i].setFont(new Font("SansSerif",Font.ITALIC,24));
    }
    // Fuege die Buttons dem Frame hinzu
    for (int i = 0; i < 4; i++) {
      c.add(b[i]);
    }
  }
  public static void main(String[] args) {
    FrameMitButtons fenster = new FrameMitButtons();
    fenster.setTitle("Frame mit Buttons");
    fenster.setSize(250,130);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
