package ch.ibw.swing.folien;

import javax.swing.*;
import java.awt.*;

public class HorizontalBoxTest {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Horizontal Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        box.add(new JButton("Left"));
        box.add(new JButton("Right"));
        frame.add(box, BorderLayout.NORTH);
        box = Box.createHorizontalBox();
        box.add(new JButton("Left"));
        box.add(Box.createHorizontalGlue());
        box.add(new JButton("Right"));
        frame.add(box, BorderLayout.CENTER);
        box = Box.createHorizontalBox();
        box.add(new JButton("Left"));
        box.add(new JButton("Right"));
        box.add(Box.createHorizontalGlue());
        frame.add(box, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
