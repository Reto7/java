package Fach_2_Objektorientierung.A97_Grafik;

/**
 * Created by user on 23.10.2016.
 */

import Prog1Tools.*;

/**
 * Diese Klasse soll einen Kreis zeichnen. Leider war der
 * Autor zu faul, die Klasse zu kommentieren ;-)
 */
public class KreisPlot implements Plottable {

    public double inf() {
        return 0;
    }

    public double sup() {
        return 2 * Math.PI;
    }

    public double x(double t) {
        return Math.sin(t);
    }

    public double y(double t) {
        return Math.cos(t);
    }

    public static void main(String[] args) {
        Plotter p = new Plotter(new KreisPlot(), "Kreisplot");
        p.adjustGrid(0.2, 0.2);
        p.showGrid(true);
        p.setNumOfPoints(9);
        p.setVisible(true);
        System.out.print("zum Beenden bitte das ");
        System.out.println("Grafikfenster schliessen.");
    }
}