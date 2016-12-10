package Fach_5_ParalleleProgrammierung.RaceCondition;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by user on 10.12.2016.
 */
public class RaceCar extends Thread {

    private int startLine;
    private Graphics g;
    private String driverName;

    // constructor
    public RaceCar(Graphics g, String driverName, int startLine) {
        this.g = g;
        this.driverName = driverName;
        this.startLine = startLine;
    }

    // das in der run() Methode kann parallel ablaufen
    @Override
    public void run() {
        System.out.println("Started " +driverName);

        Graphics2D g2 = (Graphics2D) this.g;
        Line2D lin;

        lin = new Line2D.Float(100, this.startLine, 100, this.startLine);

        Float nextPosition;
        for (int i=1; i<=10; i++) {

            nextPosition = Float.valueOf(100+(i*10));
            System.out.println(driverName +" " +i +": " +nextPosition);

            lin.setLine(100, this.startLine, nextPosition, this.startLine);
            g2.draw(lin);
/*
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
*/
        }
    }

}
