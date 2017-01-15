package Fach_3_Swing.ch.ibw.swing.AufgabenUebungBlatt;

import java.awt.*;

import javax.swing.*;

/**
 * Created by rk on 22.11.16.
 */
public class JClosableFrameVerwendung {
    JClosableFrame f;
    Button b1;
    String mainTitle = "Man nennt es \"Das Fenster\"";

    public JClosableFrameVerwendung() {  // Konstruktor
        f = new JClosableFrame("FlowLayout");
        f.setPreferredSize(new Dimension(600, 200));
        f.setTitle(mainTitle);

        JPanel jp = new JPanel();
        b1 = new Button("ein Knopf");
        b1.setActionCommand("button1");  //button identifier
        jp.add(b1);
        f.add(jp); // Füge Panel zu Frame
        f.pack(); // Berechne Layout
        f.setVisible(true);// Zeige alles an
    }

}
