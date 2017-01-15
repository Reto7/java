package Fach_3_Swing.ch.ibw.swing.A145_Spruch_des_Tages;

import javax.swing.*;

/**
 * Created by user on 21.11.2016.
 */
public class SpruchTest {
    public static void main(String[] args) {
        SpruchDesTages s = new SpruchDesTages();
        s.setTitle("Frame mit Textfeldern");
        s.setSize(400,300);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
