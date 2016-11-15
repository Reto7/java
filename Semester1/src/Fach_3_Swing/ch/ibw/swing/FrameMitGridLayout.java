package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein Swing-Fenster mit GridLayout */
public class FrameMitGridLayout extends JFrame {
  Container c;          // Container dieses Frames
  // Feld fuer Labels, die im Frame erscheinen sollen
  FarbigesLabel fl[] = new FarbigesLabel[6];
  
  public FrameMitGridLayout() {    // Konstruktor
    c = getContentPane();                   // Container bestimmen
    c.setLayout(new GridLayout(2,3,10,40)); // Layout setzen
    
    /* Erzeuge die Labelobjekte mit Text und Farbe */
    for (int i = 0; i < 6; i++) {
      int rgbFg = 255 - i*50;
      int rgbBg = i*50;
      fl[i] = new FarbigesLabel("Nummer " + (i+1), 
                                new Color(rgbFg,rgbFg,rgbFg), 
                                new Color(rgbBg,rgbBg,rgbBg));
      fl[i].setFont(new Font("Serif",Font.ITALIC,10 + i*3));
    }
    // Fuege die Labels dem Frame hinzu
    for (int i = 0; i < 6; i++) {
      c.add(fl[i]);
    }
  }
  public static void main(String[] args) {
    FrameMitGridLayout fenster = new FrameMitGridLayout();
    fenster.setTitle("Frame mit GridLayout");
    fenster.setSize(300,150);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
