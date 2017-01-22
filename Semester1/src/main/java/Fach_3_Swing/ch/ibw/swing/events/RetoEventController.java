package Fach_3_Swing.ch.ibw.swing.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetoEventController implements ActionListener {

    RetoEventView view;

    public RetoEventController(RetoEventView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("command: " +actionEvent.getActionCommand());
        if (actionEvent.getActionCommand() == RetoEventView.OKBUTTON ) {
            view.aktualisiereAnzeige("OK gedrueckt");
        } else if (actionEvent.getActionCommand() == RetoEventView.CANCELBUTTON ) {
            view.aktualisiereAnzeige("CANCEL gedrueckt");
        }
    }
}