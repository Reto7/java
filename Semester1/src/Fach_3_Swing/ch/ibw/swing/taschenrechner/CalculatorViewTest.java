package Fach_3_Swing.ch.ibw.swing.taschenrechner;

import javax.swing.*;

/**
 * Created by rk on 13.12.16.
 */
public class CalculatorViewTest {
    public static void main(String[] args) {
        setUp();
    }

    public static void setUp() {
        JFrame f = new JFrame("Taschenrechner");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new CalculatorView());

        f.pack();
        f.setVisible(true);
    }
}
