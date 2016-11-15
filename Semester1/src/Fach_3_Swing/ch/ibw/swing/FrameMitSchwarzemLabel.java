package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein Swing-Fenster mit schwarzem Textlabel */
public class FrameMitSchwarzemLabel extends JFrame {
  Container c;                  // Container dieses Frames
  FarbigesLabel schwarzesLabel; // Label, das im Frame erscheinen soll

  public FrameMitSchwarzemLabel() {  // Konstruktor
    c = getContentPane();               // Container bestimmen
    c.setLayout(new FlowLayout());      // Layout setzen

    // Erzeuge das Labelobjekt mit Uebergabe des Labeltextes
    schwarzesLabel = new FarbigesLabel("schwarzes Label", 
                                       new Color(255,255,255), 
                                       Color.BLACK);
    // Fuege das Label dem Frame hinzu
    c.add(schwarzesLabel);
  }
  public static void main(String[] args) {
    FrameMitSchwarzemLabel fenster = new FrameMitSchwarzemLabel();
    fenster.setTitle("Frame mit schwarzem Label");
    fenster.setSize(300,60);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
