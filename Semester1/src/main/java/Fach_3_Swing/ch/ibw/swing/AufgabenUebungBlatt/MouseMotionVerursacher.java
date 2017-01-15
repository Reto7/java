package Fach_3_Swing.ch.ibw.swing.AufgabenUebungBlatt;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

/**
 * Created by rk on 22.11.16.
 */
public class MouseMotionVerursacher {
    JFrame f;
    JLabel b1;
    String mainTitle = "Farbwechsel | Pos";

    Dimension maxDim;
    int eigeneBreite;
    int eigeneHoehe;

    public MouseMotionVerursacher() {  // Konstruktor
        f = new JFrame("FlowLayout");
        f.setName("MainJFrame");
        f.setPreferredSize(new Dimension(256, 256));
        f.setTitle(mainTitle);

        JPanel jp = new JPanel();
        b1 = new JLabel("ein Label");
        b1.setName("DasJLabel");

        jp.add(b1);
        f.add(jp); // Füge Panel zu Frame

        //Beende Anwendung beim Schliesen des Fensters
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack(); // Berechne Layout
        f.setVisible(true);// Zeige alles an

        // Registriere ComponentListener beim Frame
        //f.addMouseListener(new MeinMouseEventListener());
        f.addMouseMotionListener(new MeinMouseMotionListener());
    }


 /*
    // Innere Listener-Klasse
    public class MeinMouseEventListener extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO, soll sein:  javax.swing.JLabel
            System.out.println("Verursacher  ???: " +e.getComponent().getName());
        }
    }
*/

    // Innere Listener-Klasse
    public class MeinMouseMotionListener extends MouseMotionAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO, soll sein:  javax.swing.JLabel
            System.out.println("Verursacher: " +e.getComponent().getName());

            // xy ausgeben
            b1.setText(" x=" +e.getX() + " y=" +e.getY() );

            // xy fuer farben nuetzen
            b1.setForeground(new Color(e.getX(),e.getY(),0));
        }
    }

}
