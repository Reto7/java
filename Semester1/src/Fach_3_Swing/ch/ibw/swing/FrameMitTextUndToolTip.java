package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein einfaches Fenster mit einem Textlabel und Tooltip */
public class FrameMitTextUndToolTip extends JFrame {
  Container c;          // Container dieses Frames
  JLabel beschriftung;  // Label, das im Frame erscheinen soll

  public FrameMitTextUndToolTip() {  // Konstruktor 
    // Bestimme die Referenz auf den eigenen Container           
    c = getContentPane();
    // Setze das Layout
    c.setLayout(new FlowLayout());
    // Erzeuge das Labelobjekt mit Uebergabe des Labeltextes
    beschriftung = new JLabel("Label-Text im Frame");
    // Fuege das Label dem Frame hinzu
    c.add(beschriftung);
    // Fuege dem Label einen Tooltip hinzu
    beschriftung.setToolTipText("Des isch nur en Tescht!");
  }
  public static void main(String[] args) {
    FrameMitTextUndToolTip fenster = new FrameMitTextUndToolTip();
    fenster.setTitle("Frame mit Text im Label mit Tooltip");
    fenster.setSize(400,150);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
