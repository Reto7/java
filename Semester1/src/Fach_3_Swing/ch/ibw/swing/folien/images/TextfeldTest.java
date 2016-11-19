package ch.ibw.swing.folien;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextfeldTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ein Fenster mit Textfeld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JTextField("Editier mich. Ich bin ein JTexfield", 60));
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}