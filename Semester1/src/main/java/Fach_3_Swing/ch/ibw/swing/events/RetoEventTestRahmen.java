package Fach_3_Swing.ch.ibw.swing.events;

import javax.swing.*;

/**
 * Created by user on 22.01.2017.
 */
public class RetoEventTestRahmen {
    public static void main(String[] args) {
        RetoEventView r = new RetoEventView();
        r.setTitle("Test");
        r.setSize(240,160);
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
