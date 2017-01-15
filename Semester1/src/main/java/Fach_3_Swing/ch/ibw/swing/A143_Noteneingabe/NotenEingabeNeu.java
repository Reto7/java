package Fach_3_Swing.ch.ibw.swing.A143_Noteneingabe;

import java.awt.*;
import javax.swing.*;
public class NotenEingabeNeu extends JFrame {

    Container c;

    public NotenEingabeNeu() {
        c = getContentPane();
        c.setLayout(new GridLayout(5, 1));

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.PAGE_AXIS));
        c.add(radioPanel);

        JRadioButton rb6 = new JRadioButton ("sehr gut");
        JRadioButton rb5 = new JRadioButton ("gut");
        JRadioButton rb4 = new JRadioButton ("befriedigend");
        JRadioButton rb3 = new JRadioButton ("ausreichend");
        JRadioButton rb2 = new JRadioButton ("ungenuegend");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb6);
        bg.add(rb5);
        bg.add(rb4);
        bg.add(rb3);
        bg.add(rb2);
        //
        radioPanel.add(rb6);
        radioPanel.add(rb5);
        radioPanel.add(rb4);
        radioPanel.add(rb3);
        radioPanel.add(rb2);

        c.add(new JCheckBox("Aus Wiederholungsprüfung"));

    }

}