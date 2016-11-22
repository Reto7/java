package Fach_3_Swing.ch.ibw.swing.Aufgaben;

import java.awt.*;

import javax.swing.*;

/**
 * Created by rk on 17.11.16.
 */
public class RetoGui extends JFrame {

    Container c;  // Container dieses Frames
    JLabel beschriftung; // Label, das im Frame erscheinen soll


    // Konstruktor fuer unseren Frame
    public RetoGui() {
        // Bestimme die Referenz auf den eigenen Container
        c = getContentPane();
        // Setze das Layout (Layout Manager)
        c.setLayout(new FlowLayout());
        // Erzeuge das Labelobjekt mit Uebergabe des Labeltextes
        beschriftung = new JLabel("Label-Text im Frame");
        // Fuege das Label dem Frame hinzu
        c.add(beschriftung);
        // Fuege dem Label einen Tooltip hinzu
        beschriftung.setToolTipText("Des isch nur en Tescht!");
    }


    // Hauptmethode
    public static void main(String[] args) {
        // Erzeuge ein Fenster-Objekt
        //JFrame fenster = new JFrame();
        RetoGui fenster = new RetoGui();  //RetoGui ist ja ein JFrame !

        // Setze den Titel des Fensters
        fenster.setTitle("Mein erstes Swing-Fenster");
        // Setze die Groesse des Fensters
        fenster.setSize(300, 150);
        // Stelle das Fenster dar
        fenster.setVisible(true);
        // Setze das Verhalten des Frames beim Schliessen
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
