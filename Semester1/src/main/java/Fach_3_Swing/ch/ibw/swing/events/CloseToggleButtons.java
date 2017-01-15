package Fach_3_Swing.ch.ibw.swing.events;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
/** Erzeuge ein Swing-Fenster mit zwei Toggle-Buttons, 
 *  die zum Schliessen des Fensters aktiviert sein muessen */
public class CloseToggleButtons extends JFrame {
  Container c;            // Container dieses Frames
  JLabel l;               // Label
  JToggleButton b1, b2;   // Toggle-Buttons
  
  public CloseToggleButtons() {  // Konstruktor
    c = getContentPane();             // Container bestimmen
    c.setLayout(new FlowLayout());    // Layout setzen
    
    // Erzeuge die Label- und Button-Objekte
    l = new JLabel("Zum Schliessen des Fensters " + 
                   "beide Schalter aktivieren!");
    b1 = new JToggleButton("Schalter 1");
    b2 = new JToggleButton("Schalter 2");

    // Fuege die Komponenten dem Frame hinzu
    c.add(l);
    c.add(b1);
    c.add(b2);
    
    // Registriere WindowListener beim Frame
    addWindowListener(new ClosingListener());
  }
  
  // Innere Listener-Klasse
  public class ClosingListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      if (b1.isSelected() && b2.isSelected()) {
        e.getWindow().dispose();
        System.exit(0);
      }
      else
        JOptionPane.showMessageDialog(c,
               "Vor dem Schliessen erst beide Schalter aktivieren!");
    }
  }  
  
  public static void main(String[] args) {
    CloseToggleButtons fenster = new CloseToggleButtons();
    fenster.setTitle("CloseToggleButtons");
    fenster.setSize(400,100);
    fenster.setVisible(true);
    // Setze das Verhalten des Frames beim Schliessen auf "Nichtstun"
    fenster.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  }
}
