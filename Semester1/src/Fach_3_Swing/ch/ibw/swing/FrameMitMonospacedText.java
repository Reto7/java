package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein Swing-Fenster mit formatiertem Textlabel */
public class FrameMitMonospacedText extends JFrame {
  Container c;       // Container dieses Frames
  JLabel textLabel;  // Label, das im Frame erscheinen soll

  public FrameMitMonospacedText() {  // Konstruktor
    c = getContentPane();               // Container bestimmen
    c.setLayout(new FlowLayout());      // Layout setzen

    // Erzeuge das Labelobjekt mit Uebergabe des Labeltextes
    textLabel = new JLabel("Monospaced Text");
    // Setze die Schriftart fuer die Labelschriftart
    textLabel.setFont(new Font("Monospaced",Font.BOLD+Font.ITALIC,30));

    // Fuege das Label dem Frame hinzu
    c.add(textLabel);
  }
  public static void main(String[] args) {
    FrameMitMonospacedText fenster = new FrameMitMonospacedText();
    fenster.setTitle("Frame mit monospaced Text");
    fenster.setSize(300,80);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
