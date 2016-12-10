package Fach_5_ParalleleProgrammierung.RaceCondition;

import javax.swing.*;
import java.awt.*;

public class Race extends JFrame{

    public Race(){
        JPanel panel=new JPanel();
        getContentPane().add(panel);
        setSize(850,450);

        //JButton button =new JButton("press");
        //panel.add(button);
    }

    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.


        RaceCar car1 = new RaceCar(g, "Hamilton", 100);
        car1.run();


        //RaceCar car2 = new RaceCar(g, "Kaufmann", 200);
        //car2.run();

    }


    //------------------------------------------------------
    // MAIN
    //------------------------------------------------------
    public static void main(String []args){
        Race s=new Race();
        s.setVisible(true);
    }

}