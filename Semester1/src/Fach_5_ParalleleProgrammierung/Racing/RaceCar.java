package Fach_5_ParalleleProgrammierung.Racing;

import javax.swing.*;

/**
 * Created by user on 10.12.2016.
 */
public class RaceCar extends Thread {

    private JLabel labelCar;
    private String driverName;

    // constructor
    public RaceCar(String driverName, JLabel labelCar) {
        this.driverName = driverName;
        this.labelCar = labelCar;
    }

    // das in der run() Methode kann parallel ablaufen
    @Override
    public void run() {
        System.out.println("Started " +driverName);

        int nextPosition;
        for (int i=1; i<=10; i++) {

            String out = "";
            nextPosition = 1+(i*2);
            System.out.println(driverName +" " +i +": " +nextPosition);
            for (int x=1; x<nextPosition; x++) {
                out = out+"*";
            }
            System.out.println(out);
            labelCar.setText(out);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
