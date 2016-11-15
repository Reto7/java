package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein Swing-Fenster mit BorderLayout */
public class FrameMitBorderLayout extends JFrame {
  Container c;            // Container dieses Frames
  // Labelfeld fuer Label, die im Frame erscheinen sollen
  FarbigesLabel fl[] = new FarbigesLabel[5];
  
  public FrameMitBorderLayout() {    // Konstruktor
    c = getContentPane();               // Container bestimmen
    c.setLayout(new BorderLayout());    // Layout setzen
    
    /* Erzeuge die Labelobjekte mit Text und Farbe */
    fl[0] = new FarbigesLabel("Norden", Color.BLACK, Color.WHITE);
    fl[1] = new FarbigesLabel("Sueden", Color.WHITE, Color.LIGHT_GRAY);
    fl[2] = new FarbigesLabel("Osten", Color.WHITE, Color.GRAY);
    fl[3] = new FarbigesLabel("Westen", Color.WHITE, Color.DARK_GRAY);
    fl[4] = new FarbigesLabel("Zentrum", Color.WHITE, Color.BLACK);
    
    for (int i = 0; i < 5; i++) {
      // Setze die Schriftart der Labelbeschriftung
      fl[i].setFont(new Font("SansSerif",Font.BOLD,14));
      // Setze die horizontale Position des Labeltextes auf dem Label
      fl[i].setHorizontalAlignment(JLabel.CENTER);
    }
    // Fuege die Labels dem Frame hinzu
    c.add(fl[0],BorderLayout.NORTH);
    c.add(fl[1],BorderLayout.SOUTH);
    c.add(fl[2],BorderLayout.EAST);
    c.add(fl[3],BorderLayout.WEST);
    c.add(fl[4],BorderLayout.CENTER);
  }
  public static void main(String[] args) {
    FrameMitBorderLayout fenster = new FrameMitBorderLayout();
    fenster.setTitle("Frame mit BorderLayout");
    fenster.setSize(300,150);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
