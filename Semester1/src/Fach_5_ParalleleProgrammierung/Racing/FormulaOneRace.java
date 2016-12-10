package Fach_5_ParalleleProgrammierung.Racing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 10.12.2016.
 */
public class FormulaOneRace {

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
        frame.setLayout(new GridLayout(3,1));

        JLabel labelCar1 = new JLabel("Car 1");
        frame.getContentPane().add(labelCar1);

        JLabel labelCar2 = new JLabel("Car 2");
        frame.getContentPane().add(labelCar2);

        JLabel labelCar3 = new JLabel("Car 3");
        frame.getContentPane().add(labelCar3);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

        // START RACE

        RaceCar car1 = new RaceCar("Hamilton", labelCar1);
        car1.start();

        RaceCar car2 = new RaceCar("Kaufmann", labelCar2);
        car2.start();

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
