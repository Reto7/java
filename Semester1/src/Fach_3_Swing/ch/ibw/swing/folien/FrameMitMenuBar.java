package ch.ibw.swing.folien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;

/** Erzeuge ein einfaches Swing-Fenster mit einem Menue einer
    Toolbar und einem Textlabel */
public class FrameMitMenuBar extends JFrame {
  Container c;           // Container dieses Frames
  JMenuBar menuBar;      // Menueleiste
  JMenu menu;            // Menue
  JMenuItem menuItem;    // Menue-Eintrag
  JToolBar toolBar;      // Werkzeugleiste
  JButton button;        // Knoepfe der Werkzeugleiste
  JLabel textLabel;      // Label, das im Frame erscheinen soll

  public FrameMitMenuBar() {  // Konstruktor
    // Bestimme die Referenz auf den eigenen Container
    c = getContentPane();
    
    // Erzeuge die Menueleiste.
    menuBar = new JMenuBar();
    // Erzeuge ein Menue
    menu = new JMenu("Bilder");
    menu.setMnemonic(KeyEvent.VK_B);
    // Erzeuge die Menue-Eintraege und fuege sie dem Menue hinzu
    menuItem = new JMenuItem("Hund");
    menuItem.setMnemonic(KeyEvent.VK_H);
    menu.add(menuItem);
    menuItem = new JMenuItem("Katze");
    menuItem.setMnemonic(KeyEvent.VK_K);
    menu.add(menuItem);
    menuItem = new JMenuItem("Maus");
    menuItem.setMnemonic(KeyEvent.VK_M);
    menu.add(menuItem);
    // Fuege das Menue der Menueleiste hinzu
    menuBar.add(menu);
    // Fuegt das Menue dem Frame hinzu
    setJMenuBar(menuBar);
    
    // Erzeuge die Werkzeugleiste
    toolBar = new JToolBar("Rahmenfarbe");
    // Erzeuge die Knoepfe
    URL rot = FrameMitMenuBar.class.getResource("images/rot.gif");
    URL gruen = FrameMitMenuBar.class.getResource("images/gruen.gif");
    URL blau = FrameMitMenuBar.class.getResource("images/blau.gif");

    button = new JButton(new ImageIcon(rot));
    button.setToolTipText("roter Rahmen");
    toolBar.add(button);
    button = new JButton(new ImageIcon(gruen));
    button.setToolTipText("gruener Rahmen");
    toolBar.add(button);
    button = new JButton(new ImageIcon(blau));
    button.setToolTipText("blauer Rahmen");
    toolBar.add(button);
        
    // Erzeuge das Labelobjekt
    textLabel = new JLabel("Hier erscheint mal ein Bild mit Rahmen.",
                           JLabel.CENTER);
    // Fuege Label und Toolbar dem Container hinzu
    c.add(textLabel, BorderLayout.CENTER);
    c.add(toolBar, BorderLayout.NORTH);
  }
  public static void main(String[] args) {
    FrameMitMenuBar fenster = new FrameMitMenuBar();
    fenster.setTitle("Frame mit Menueleiste und Toolbar");
    fenster.setSize(350,170);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
