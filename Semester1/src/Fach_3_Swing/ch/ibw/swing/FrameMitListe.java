package ch.ibw.swing;

import javax.swing.*;
import java.awt.*;
/** Erzeuge ein Swing-Fenster mit Liste */
public class FrameMitListe extends JFrame {
  Container c;            // Container dieses Frames
  // Liste und Combo-Box, die im Frame erscheinen sollen
  JList vornamen;
  JComboBox nachnamen;
  
  public FrameMitListe() {  // Konstruktor
    c = getContentPane();             // Container bestimmen
    c.setLayout(new FlowLayout());    // Layout setzen

    // Eintraege fuer Vornamen-Combo-Box festlegen
    String[] namen = new String[] { "Bilbo", "Frodo", "Samwise", 
                                    "Meriadoc", "Peregrin" };
    vornamen = new JList(namen);      // Liste mit Eintraegen
    nachnamen = new JComboBox();      // Leere Combo-Box
    nachnamen.addItem("Baggins");     // Eintraege hinzufuegen
    nachnamen.addItem("Brandybuck");
    nachnamen.addItem("Gamgee"); 
    nachnamen.addItem("Took");
    // Liste und Combo-Box dem Frame hinzufuegen       
    c.add(vornamen);
    c.add(nachnamen);
  }
  public static void main(String[] args) {
    FrameMitListe fenster = new FrameMitListe();
    fenster.setTitle("Frame mit Liste");
    fenster.setSize(240,160);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
