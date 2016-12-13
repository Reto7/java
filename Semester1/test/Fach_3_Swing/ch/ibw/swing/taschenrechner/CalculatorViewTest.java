package Fach_3_Swing.ch.ibw.swing.taschenrechner;

import org.junit.Test;

import javax.swing.*;

/**
 * Created by rk on 13.12.16.
 */
public class CalculatorViewTest {

    @Test
    public void testGuiExpectSimpleView() throws Exception {

        JFrame f = new JFrame("Taschenrechner");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new CalculatorView());
        f.pack();
        f.setVisible(true);

        Thread.sleep(5000);
    }

}