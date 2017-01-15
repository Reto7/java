package Fach_3_Swing.ch.ibw.swing.AufgabenUebungBlatt;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

/**
 * Created by rk on 22.11.16.
 */
public class Einrasten {
    JFrame f;
    Button b1;
    String mainTitle = "Man nennt es \"Das Fenster\"";

    Dimension maxDim;
    int eigeneBreite;
    int eigeneHoehe;

    public Einrasten() {  // Konstruktor
        f = new JFrame("FlowLayout");
        f.setPreferredSize(new Dimension(600, 200));
        f.setTitle(mainTitle);

        JPanel jp = new JPanel();
        b1 = new Button("ein Knopf");
        b1.setActionCommand("button1");  //button identifier
        jp.add(b1);
        f.add(jp); // Füge Panel zu Frame

        //Beende Anwendung beim Schliesen des Fensters
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack(); // Berechne Layout
        f.setVisible(true);// Zeige alles an

        // maximale Aufloesung
        maxDim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("dimension max: " + maxDim);

        eigeneBreite = f.getWidth();
        eigeneHoehe = f.getHeight();

        // Registriere ComponentListener beim Frame
        f.addComponentListener(new MeinComponentListener());
    }

    // Innere Listener-Klasse
    public class MeinComponentListener extends ComponentAdapter {
        @Override
        public void componentMoved(ComponentEvent e) {
            //System.out.println(e.getComponent().getX());
            if (e.getComponent().getX() < 50) {
                // setlocation
                f.setLocation(0, e.getComponent().getY());
            }
            if (e.getComponent().getY() < 50) {
                // setlocation
                f.setLocation(e.getComponent().getX(), 0);
            }

            // Auflösung WIDTH 1000
            // Windowbreite     100
            // Relevante Position von Window obenlinks 1000-100=900
            int posRechts = (int) (maxDim.getWidth() - eigeneBreite);
            if (e.getComponent().getX() > posRechts-50) {
                // setlocation
                f.setLocation(posRechts, e.getComponent().getY());
            }
            //
            int posUnten = (int) (maxDim.getHeight() - eigeneHoehe);
            if (e.getComponent().getY() > posUnten-50) {
                // setlocation
                f.setLocation(e.getComponent().getX(), posUnten);
            }

            f.setTitle(mainTitle
                    + " x=" +e.getComponent().getX()
                    + " y=" +e.getComponent().getY()
                  //  + " (x=" +(posRechts-50)
                  //  + " y=" +(posUnten-50)     +")"
            );
        }
    }

}
