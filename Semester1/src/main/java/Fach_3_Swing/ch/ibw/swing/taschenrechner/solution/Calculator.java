package Fach_3_Swing.ch.ibw.swing.taschenrechner.solution;

import javax.swing.JFrame;

/**
 * Die Klasse Calculator enthaelt nur eine
 * Mainmethode und dient dazu ein Frame 
 * zu erzeugen, um die View des Taschenrechners
 * darzustellen.
 * 
 * @author jkrueger
 */

public class Calculator {

    public static void main(String[] args) {
        JFrame f = new JFrame("Taschenrechner");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new CalculatorView());
        f.pack();
        f.setVisible(true);

    }
}
