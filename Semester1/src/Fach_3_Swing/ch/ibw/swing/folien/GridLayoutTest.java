package ch.ibw.swing.folien;

import javax.swing.*;
import java.awt.*;

public class GridLayoutTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("GridLayout");
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3,4));
        for (char c = 0; c < 11; ++c) {
            jp.add(new JButton("Button " + (char)('A'+c)));
        }
        JTextArea jta =new JTextArea(3,10);
        jta.append("JTextArea \nsecond row\nthird row");
        jp.add(jta);
        f.add(jp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
