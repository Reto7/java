package Fach_3_Swing.ch.ibw.swing.uebungen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Michele on 22.11.2016.
 */
public class MouseTitle extends JFrame {

    public MouseTitle()
    {
        String title = "Frame ohne Inhalt";
        // Titelleiste definieren
        setTitle(title);
        // Setze die Groesse des Frames
        setSize(400, 200);
        // Schalte den Frame sichtbar
        setVisible(true);
        // Setze das Verhalten des Frames beim Schliessen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                setTitle(title+ " x="+e.getX() + " y="+e.getY());
            }
        });
    }

    public static void main(String[] args)
    {
        MouseTitle frame = new MouseTitle();
    }
}
