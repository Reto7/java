package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/** Erzeuge ein einfaches Swing-Fenster mit einem Label */
public class FrameMitBild extends JFrame {
  Container c;          // Container dieses Frames
  JLabel lab;           // Label, das im Frame erscheinen soll

  public FrameMitBild() {  // Konstruktor 
    c = getContentPane();            // Container bestimmen 
    c.setLayout(new FlowLayout());   // Layout setzen 

    // Bildobjekt erzeugen
    URL bildJpg = FrameMitBild.class.getResource("babycat.jpg");
    Icon bild = new ImageIcon(bildJpg);
    // Label mit Text und Bild beschriften
    lab = new JLabel("Spotty", bild, JLabel.CENTER);
    // Text unter das Bild setzen
    lab.setHorizontalTextPosition(JLabel.CENTER);
    lab.setVerticalTextPosition(JLabel.BOTTOM);
    // Fuege das Label dem Frame hinzu
    c.add(lab);
  }
  public static void main(String[] args) {
    FrameMitBild fenster = new FrameMitBild();
    fenster.setTitle("Label mit Bild und Text");
    fenster.setSize(250,185);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
