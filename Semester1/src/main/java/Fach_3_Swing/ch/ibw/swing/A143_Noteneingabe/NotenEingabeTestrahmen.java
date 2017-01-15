package Fach_3_Swing.ch.ibw.swing.A143_Noteneingabe;

import javax.swing.*;

/**
 * Created by user on 19.11.2016.
 */
public class NotenEingabeTestrahmen {

    public static void main(String[] args) {
        NotenEingabe n = new NotenEingabe();
        n.setSize(150,200);
        n.setVisible(true);  // !
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NotenEingabeNeu neu = new NotenEingabeNeu();
        neu.setSize(600,600);
        neu.setVisible(true);  // !
        neu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
