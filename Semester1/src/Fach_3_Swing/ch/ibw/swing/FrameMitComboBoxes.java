package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;

/** Erzeuge ein Swing-Fenster mit ComboBoxes */
public class FrameMitComboBoxes extends JFrame {
  Container c;            // Container dieses Frames
  // Combo-Boxes, die im Frame erscheinen sollen
  JComboBox vornamen, nachnamen;
  
  public FrameMitComboBoxes() {  // Konstruktor
    c = getContentPane();             // Container bestimmen
    c.setLayout(new FlowLayout());    // Layout setzen

    // Eintraege fuer Vornamen-Combo-Box festlegen
    String[] namen = new String[] { "Bilbo", "Frodo", "Samwise", 
                                    "Meriadoc", "Peregrin" };
    vornamen = new JComboBox(namen);  // Combo-Box mit Eintraegen
    nachnamen = new JComboBox();      // Leere Combo-Box
    nachnamen.addItem("Baggins");     // Eintraege hinzufuegen
    nachnamen.addItem("Brandybuck");
    nachnamen.addItem("Gamgee"); 
    nachnamen.addItem("Took");
    // Den dritten Nachnamen (Index 2) selektieren
    nachnamen.setSelectedIndex(2);
    // Combo-Boxes dem Frame hinzufuegen       
    c.add(vornamen);
    c.add(nachnamen);
  }
  public static void main(String[] args) {
    FrameMitComboBoxes fenster = new FrameMitComboBoxes();
    fenster.setTitle("Frame mit ComboBoxes");
    fenster.setSize(240,160);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
