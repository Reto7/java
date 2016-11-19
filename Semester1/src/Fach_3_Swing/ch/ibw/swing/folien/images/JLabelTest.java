package ch.ibw.swing.folien;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelTest {

    public static void main(String[] args) {
        JFrame f = new JFrame("Das Fenster zur Welt!");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JLabel("Hinweistext!"));
        f.setSize(100, 80);
        f.setVisible(true);
    }
}