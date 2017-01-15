package Fach_3_Swing.ch.ibw.swing.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListenerAufwaendig implements MouseListener {
    /* leere Implementierung, erzwungen */

        /* leere Implementierung, erzwungen */

    @Override
    public void mouseClicked(MouseEvent mEvent)
    {
        System.out.println("MouseClick wurde auf Position ["
                + mEvent.getX() + ","
                + mEvent.getY() + "] "
                + mEvent.getClickCount() + " mal geklickt");
    }

    @Override
    public void mouseEntered(MouseEvent mEvent){

    }

    @Override
    public void mouseExited(MouseEvent mEvent){

    }

    @Override
    public void mousePressed(MouseEvent mEvent)
    { /* leere Implementierung, erzwungen */ }

    @Override
    public void mouseReleased(MouseEvent mEvent)
    { /* leere Implementierung, erzwungen */ }
}
