package Fach_3_Swing.ch.ibw.swing.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/** Erzeuge ein Swing-Fenster, das mit Buttons und 
 *  Combo-Box sein Look and feel aendern kann */
public class LookAndFeel extends JFrame {
  Container c;              // Container dieses Frames
  JButton b1, b2, b3;       // Buttons
  JComboBox cb;             // Combo-Box
  JFrame f = this;          // Referenz auf dieses Frame
  
  public LookAndFeel() {    // Konstruktor
    c = getContentPane();             // Container bestimmen
    c.setLayout(new FlowLayout());    // Layout setzen
    
    // Erzeuge die Buttons und die Combo-Box
    b1 = new JButton("Metal");
    b2 = new JButton("Motif");
    b3 = new JButton("Windows");
    cb = new JComboBox();
    cb.addItem("Metal");
    cb.addItem("Motif");
    cb.addItem("Windows");

    // Fuege die Komponenten dem Frame hinzu
    c.add(b1);
    c.add(b2);
    c.add(b3);
    c.add(cb);
    
    // Erzeuge den Listener und registriere ihn
    LafListener ll = new LafListener();
    b1.addActionListener(ll);
    b2.addActionListener(ll);
    b3.addActionListener(ll);
    cb.addItemListener(ll);
  }
  // Innere Listener-Klasse
  public class LafListener implements ItemListener,ActionListener {
    // Fuer die Look-and-feel-Auswahl
    String[] laf = 
               {"javax.swing.plaf.metal.MetalLookAndFeel",
                "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"};
        
    // Fuer das ItemListener-Interface
    public void itemStateChanged(ItemEvent e) {
      try {
        int i = cb.getSelectedIndex();
        UIManager.setLookAndFeel(laf[i]);
      }
      catch (Exception ex) {
        System.err.println(ex);
      }
      SwingUtilities.updateComponentTreeUI(f);
    }
    // Fuer das ActionListener-Interface
    public void actionPerformed(ActionEvent e) {
      try {
        int i;
        if (e.getSource() == b1)
          i = 0;
        else if (e.getSource() == b2) 
          i = 1;
        else 
          i = 2;
        UIManager.setLookAndFeel(laf[i]);
        cb.setSelectedIndex(i);
      }
      catch (Exception ex) {
        System.err.println(ex);
      }
      SwingUtilities.updateComponentTreeUI(f);
    }
  }  
  public static void main(String[] args) {
    LookAndFeel fenster = new LookAndFeel();
    fenster.setTitle("Look and feel einstellen");
    fenster.setSize(250,100);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
