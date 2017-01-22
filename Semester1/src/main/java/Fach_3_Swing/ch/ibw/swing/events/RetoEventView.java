package Fach_3_Swing.ch.ibw.swing.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 22.01.2017.
 */
public class RetoEventView extends JFrame {

    public static final String OKBUTTON = "okPressed";
    public static final String CANCELBUTTON = "cancelPressed";

    // neuer Controller instanzieren, wir geben ihm als Parameter uns selber (view) mit
    // damit kann der Controller dann Daten direkt zu uns zurueckgeben
    private RetoEventController cntl = new RetoEventController(this);

    JLabel anzeige;
    public void aktualisiereAnzeige(String anzeigeText) {
        this.anzeige.setText(anzeigeText);
    }

    //Constructor
    RetoEventView() {
        // 2 Rows, 1 Spalte
        this.setLayout(new GridLayout(2,1));

        JButton okButton = new JButton("ok");
        // ACTIONLISTENER!
        okButton.addActionListener(cntl);
        okButton.setActionCommand(OKBUTTON);

        JButton cancelButton = new JButton("cancel");
        // ACTIONLISTENER!
        cancelButton.addActionListener(cntl);
        cancelButton.setActionCommand(CANCELBUTTON);

        anzeige = new JLabel();
        anzeige.setText("-");

        // aufs Layout
        this.add(okButton);
        this.add(cancelButton);
        this.add(anzeige);
    }

//  //--------------------------------------------------------------------
//  //als innere klasse
//    private class RetoEventController implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent actionEvent) {
//            System.out.println("command: " +actionEvent.getActionCommand());
//            if (actionEvent.getActionCommand() == RetoEvent.OKBUTTON ) {
//
//            }
//        }
//  //--------------------------------------------------------------------
//  //als anonyme klasse (als Parameter in okButton.addActionListener()  )
//      new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent actionEvent) {
//        }
//    };

}
