package ch.ibw.swing;

import java.awt.*;
import javax.swing.*;
public class FarbigesLabel extends JLabel {
  public FarbigesLabel(String text,Color fG,Color bG) { // Konstruktor
    // Uebergabe des Labeltextes an den Super-Konstruktor
    super(text);
    // Setze den Hintergrund des Labels auf undurchsichtig
    setOpaque(true);
    // Setze die Farbe der Beschriftung des Labels
    setForeground(fG);
    // Setze die Hintergrundfarbe des Labels
    setBackground(bG);
  }
}
