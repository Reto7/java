package Fach_3_Swing.ch.ibw.swing.folien;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameTest {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Einfaches Fenster");
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b = new JButton("klick mich");
        b.setSize(50,50);
        Dimension pf = new Dimension();
        pf.setSize(50,50);
        b.setPreferredSize(pf);


        //myFrame.add(new JButton("Click mich ich bin ein JButton!"));
        myFrame.add(b);

        myFrame.setSize(600,200);
        myFrame.setVisible(true);
    }
}