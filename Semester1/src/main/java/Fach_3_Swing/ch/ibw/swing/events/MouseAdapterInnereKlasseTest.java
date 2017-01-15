package Fach_3_Swing.ch.ibw.swing.events;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAdapterInnereKlasseTest {
    /**
     * Erzeuge GUI im Konstruktor
     */
    public MouseAdapterInnereKlasseTest()
    {
        JFrame myJFrame = new JFrame("Mouse Click Innere Klasse Test");
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jb = new JButton("Hier drücken");
        jb.addMouseListener(new MyMouseListener());
        myJFrame.getContentPane().add(jb);
        myJFrame.pack();
        myJFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        MouseAdapterInnereKlasseTest mat =
                new MouseAdapterInnereKlasseTest();
    }

    /**
     * Die innere Klasses MyMouseListener
     */
    class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent mEvent)
        {
            System.out.println("MouseClick wurde auf Position ["
                    + mEvent.getX() + ","
                    + mEvent.getY() + "] "
                    + mEvent.getClickCount() + " mal geklickt");
        }
    }
}
