package Fach_3_Swing.ch.ibw.swing.A144_TextFelderAuslesen;

import Prog1Tools.IOTools;

import javax.swing.*;

/**
 * Created by user on 21.11.2016.
 */
public class TextFelderAuslesen {
    public static void main(String[] args) {

        FrameMitTextFeldern fenster = new FrameMitTextFeldern();
        fenster.setTitle("Frame mit Textfeldern");
        fenster.setSize(220,100);
        fenster.setVisible(true);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        IOTools.readLine("Geben Sie im Frame in beide Textfelder etwas ein.\n" +
                "Druecken Sie danach hier im Konsolenfenster die Eingabetaste!");

        System.out.println("Inhalt Feld User: " +fenster.tf.getText());
      //System.out.println("Inhalt Feld Pw: " +fenster.pf.getText());  -- veraltet!
        System.out.println("Inhalt Feld Pw: " +new StringBuilder().append(fenster.pf.getPassword()));
    }

}
