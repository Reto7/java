package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein Swing-Fenster mit FlowLayout */
public class FrameMitFlowLayout extends JFrame {
  Container c;            // Container dieses Frames
  // Feld fuer Labels, die im Frame erscheinen sollen
  FarbigesLabel fl[] = new FarbigesLabel[4];
  
  public FrameMitFlowLayout() {    // Konstruktor
    c = getContentPane();             // Container bestimmen
    c.setLayout(new FlowLayout());    // Layout setzen
    
    // Erzeuge die Labelobjekte mit Uebergabe der Labeltexte
    for (int i = 0; i < 4; i++) {
      int rgbFg = 255 - i*80;    // Farbwert fuer Vordergrund
      int rgbBg = i*80;          // Farbwert fuer Hintergrund
      fl[i] = new FarbigesLabel("Nummer " + (i+1), 
                                new Color(rgbFg,rgbFg,rgbFg), 
                                new Color(rgbBg,rgbBg,rgbBg));
      fl[i].setFont(new Font("Serif",Font.ITALIC,28));
    }
    // Fuege die Labels dem Frame hinzu
    for (int i = 0; i < 4; i++) {
      c.add(fl[i]);
    }
  }
 
  public static void main(String[] args) {
    FrameMitFlowLayout fenster = new FrameMitFlowLayout();
    fenster.setTitle("Frame mit FlowLayout");
    fenster.setSize(300,150);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
