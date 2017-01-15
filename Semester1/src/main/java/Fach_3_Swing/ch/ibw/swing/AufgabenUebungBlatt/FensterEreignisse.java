package Fach_3_Swing.ch.ibw.swing.AufgabenUebungBlatt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/**
 * Created by rk on 22.11.16.
 */
public class FensterEreignisse {
    JFrame f;
    Button b1;
    String mainTitle = "Man nennt es \"Das Fenster\"";

    public FensterEreignisse() {  // Konstruktor
        f = new JFrame("FlowLayout");
        f.setPreferredSize(new Dimension(600, 200));
        f.setTitle(mainTitle);

        JPanel jp = new JPanel();
        b1 = new Button("ein Knopf");
        b1.setActionCommand("button1");  //button identifier
        jp.add(b1);
        f.add(jp); // Füge Panel zu Frame
        f.pack(); // Berechne Layout
        f.setVisible(true);// Zeige alles an

        // Registriere WindowListener beim Frame
        f.addWindowListener(new MeinWindowListener());
    }

    // Innere Listener-Klasse
    public class MeinWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.out.println("... und tschüss");
            System.exit(0);
        }
    }


}
