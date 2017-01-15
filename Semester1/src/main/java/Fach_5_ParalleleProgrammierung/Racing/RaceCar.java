package Fach_5_ParalleleProgrammierung.Racing;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

/**
 * Created by user on 10.12.2016.
 */
public class RaceCar extends Thread {

    private JLabel labelCar;
    private JLabel labelTotalKM;
    private String driverName;
    private int anzahlRunden;
    private String lock = "lock";

    // zentrale variable um die anzahl km aller fahrer mitzuzaehlen
    private static int totalKmAllerFahrer;

    // constructor
    public RaceCar(String driverName, JLabel labelCar, int anzahlRunden, JLabel labelTotalKM) {
        this.driverName = driverName;
        this.labelCar = labelCar;
        this.anzahlRunden = anzahlRunden;
        this.labelTotalKM = labelTotalKM;
    }

    // das in der run() Methode kann parallel ablaufen
    @Override
    public void run() {
        System.out.println("Started " +driverName);

        int kmGefahren;
        for (int i=1; i<=this.anzahlRunden; i++) {
            String out = "";
            kmGefahren = 1+(i*2);
            System.out.println(driverName +" " +i +": " +kmGefahren);
            for (int x=1; x<kmGefahren; x++) {
                out = out+"*";
            }
            out = out + kmGefahren +"km";
            //System.out.println(out);
            labelCar.setText(out);
            // gefahrene KM in total hochzaehlen
            totalKmAllerFahrer = totalKmAllerFahrer + kmGefahren;
            labelTotalKM.setText(String.valueOf(totalKmAllerFahrer));


            try {
                Thread.sleep(getRandomTimeForSleeper(1,400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("totalKmAllerFahrer " +totalKmAllerFahrer);
    }

    private int getRandomTimeForSleeper(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
