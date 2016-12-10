package Fach_5_ParalleleProgrammierung.RaceCondition;

import javax.swing.*;
import java.awt.*;

public class Race extends JFrame{

    private int SwingProblemCounter = 0;
    private boolean raceIsStarted = false;

    public Race(){
        JPanel panel=new JPanel();
        getContentPane().add(panel);
        setSize(850,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //JButton button =new JButton("press");
        //panel.add(button);
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }


    public void drawLines(Graphics g) {
        super.paint(g);  // fixes the immediate problem.



        //Calling setPreferredSize() and pack() will cause paintComponent()
        // to be called twice because the display needs to be redrawn for
        // each call.
        SwingProblemCounter++;
        if (SwingProblemCounter >1 && !raceIsStarted) {

            raceIsStarted = true;

            RaceCar car1 = new RaceCar(g, "Hamilton", 100);
            car1.run();

            RaceCar car2 = new RaceCar(g, "Kaufmann", 200);
            car2.run();
        }

    }


    //------------------------------------------------------
    // MAIN
    //------------------------------------------------------
    public static void main(String []args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Race r = new Race();
                r.setVisible(true);
            }
        });

    }

}