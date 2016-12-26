package Fach_3_Swing.ch.ibw.swing.MVC.einfach;

/**
 * Created by user on 26.12.2016.
 */
import javax.swing.*;
import java.awt.BorderLayout;

public class View {

    // Note that View don't know anything about Model and Controller.

    private JFrame frame;
    private JLabel label;
    private JButton button;

    /* constructor */
    public View(String text){
        frame = new JFrame("View");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);

        label = new JLabel(text);
        frame.getContentPane().add(label, BorderLayout.CENTER);

        button = new JButton("Button");
        frame.getContentPane().add(button, BorderLayout.SOUTH);
    }

    /* returns Button Reference */
    public JButton getButton(){
        return button;
    }

    /* PUBLIC! */
    public void setText(String text){
        label.setText(text);
    }


}
