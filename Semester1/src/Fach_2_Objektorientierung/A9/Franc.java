package Fach_2_Objektorientierung.A9;

/**
 * Created by rk on 04.10.16.
 */

public class Franc extends Euro {

    /**
     * Konstruktor EINGABE FRANC, gleich in Euro gehen
     */
    public Franc(double x) {

        super(x / kurs);  //Wert des Geldbetrags in Euro
    }

    /**
     * Konstruktor, kann hierbei EURO, DM, LIRE empfangen (den DM ist ja auch EURO)
     */
    public Franc(Euro e) {

        super(e.euroBetrag());  //Wert des Geldbetrags in Euro
    }

    /**
     * Ein Euro ist soviel Franc wert
     */
    private static double kurs = 6.55957;

    public double waehrungsBetrag() {
        return super.euroBetrag() * kurs;
    }
}