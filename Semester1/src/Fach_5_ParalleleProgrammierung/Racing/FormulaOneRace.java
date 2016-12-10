package Fach_5_ParalleleProgrammierung.Racing;

import Fach_3_Swing.ch.ibw.swing.events.Farbwechsel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 10.12.2016.
 */
public class FormulaOneRace {

    private static final int anzahlRunden = 50;

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("F1 Racing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,450);
        frame.setPreferredSize(new Dimension(850,450));
        frame.setLocationRelativeTo(null);

        // single column grid layout
        frame.setLayout(new GridLayout(6,1));

        JLabel labelTotalAnzeige = new JLabel("Total KM aller Fahrer (" +anzahlRunden +" Runden)");
        frame.getContentPane().add(labelTotalAnzeige);
        JLabel labelTotalKM = new JLabel();
        frame.getContentPane().add(labelTotalKM);

        JLabel labelCar1 = new JLabel("Car 1");
        frame.getContentPane().add(labelCar1);

        JLabel labelCar2 = new JLabel("Car 2");
        frame.getContentPane().add(labelCar2);

        JLabel labelCar3 = new JLabel("Car 3");
        frame.getContentPane().add(labelCar3);

        //////////////////////////////////////////
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        frame.getContentPane().add(buttonPanel);

        JButton stop1 = new JButton("stop 1");
        stop1.setPreferredSize(new Dimension(20,20));
        buttonPanel.add(stop1);
        JButton stop2 = new JButton("stop 2");
        stop2.setPreferredSize(new Dimension(20,20));
        buttonPanel.add(stop2);
        JButton stop3 = new JButton("stop 3");
        stop3.setPreferredSize(new Dimension(20,20));
        buttonPanel.add(stop3);
        JButton start1 = new JButton("start 1");
        start1.setPreferredSize(new Dimension(20,20));
        buttonPanel.add(start1);
        JButton start2 = new JButton("start 2");
        start2.setPreferredSize(new Dimension(20,20));
        buttonPanel.add(start2);
        JButton start3 = new JButton("start 3");
        start3.setPreferredSize(new Dimension(20,20));
        buttonPanel.add(start3);

        // Listener-Objekt erzeugen und beim Button registrieren
        ButtonListener bL = new ButtonListener();
        stop1.addActionListener(bL);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

        // START RACE
        RaceCar car1 = new RaceCar("Hamilton", labelCar1, anzahlRunden, labelTotalKM);
        car1.start();

        RaceCar car2 = new RaceCar("Kaufmann", labelCar2, anzahlRunden, labelTotalKM);
        car2.start();

        RaceCar car3 = new RaceCar("Rosberg", labelCar3, anzahlRunden, labelTotalKM);
        car3.start();
    }

    // Innere Button-Listener-Klasse
    private static class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

