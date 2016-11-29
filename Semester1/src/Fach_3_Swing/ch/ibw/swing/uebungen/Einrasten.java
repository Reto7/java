package Fach_3_Swing.ch.ibw.swing.uebungen;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

/**
 * Created by Michele on 22.11.2016.
 */
public class Einrasten extends JFrame {

    public Einrasten()
    {

        // Titelleiste definieren
        setTitle("Frame ohne Inhalt");
        // Setze die Groesse des Frames
        setSize(400, 200);
        // Schalte den Frame sichtbar
        setVisible(true);
        // Setze das Verhalten des Frames beim Schliessen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e)
            {
                Rectangle bounds = getBounds();
                if (bounds.getMaxX() > screenSize.getWidth() - 20) {
                    setLocation(screenSize.width - bounds.width, bounds.y);
                }
            }
        });

    }

    public static void main(String[] args)
    {
        Einrasten frame = new Einrasten();
    }
}
