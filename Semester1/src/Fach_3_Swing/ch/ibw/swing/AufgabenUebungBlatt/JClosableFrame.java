package Fach_3_Swing.ch.ibw.swing.AufgabenUebungBlatt;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/**
 * Created by rk on 22.11.16.
 */
public class JClosableFrame extends JFrame {


    public JClosableFrame() {  // Konstruktor

        // den parent constructor aufrufen
        super();
        // Registriere WindowListener beim Frame
        addWindowListener(new MeinWindowListener());
    }

    public JClosableFrame(String titel) {  // Konstruktor

        // den parent constructor aufrufen
        super(titel);
        // Registriere WindowListener beim Frame
        addWindowListener(new MeinWindowListener());
    }

    // Innere Listener-Klasse
    public class MeinWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.out.println("... und tschüss?");
            JOptionPane pane = new JOptionPane();
            int dialogResult = pane.showConfirmDialog(null,
                    "Soll die Applikation wirklich\n" +
                            "beendet werden?", "Beenden?", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION) {
                System.out.println("... und tschüss und weg!");
                System.exit(0);
            } else {
                System.out.println("... aktiv bleiben");
            }

        }
    }


}
