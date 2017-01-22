package Fach_3_Swing.ch.ibw.swing.Aufgaben;

import javax.swing.*;
import java.awt.*;

/** Erzeuge ein Swing-Fenster mit Liste */
public class RetoGui2 extends JFrame {

  // Liste und Combo-Box, die im Frame erscheinen sollen
  JList vornamen;
  JComboBox nachnamen;


  public RetoGui2() {  // Konstruktor

    this.setLayout(new FlowLayout());    // Layout setzen

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
    this.add(vornamen);
    this.add(nachnamen);
  }

}
