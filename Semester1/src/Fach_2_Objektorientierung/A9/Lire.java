package Fach_2_Objektorientierung.A9;

/**
 * Created by rk on 04.10.16.
 */

public class Lire extends Euro {

    /**
     * Konstruktor EINGABE LIRE, , gleich in Euro gehen
     */
    public Lire(double x) {
        super(x / kurs);  //Wert des Geldbetrags in Euro
    }

    /**
     * Konstruktor, kann hierbei EURO, DM, LIRE empfangen (den DM ist ja auch EURO)
     */
    public Lire(Euro e) {
        super(e.euroBetrag());  //Wert des Geldbetrags in Euro
    }

    /**
     * Ein Euro ist soviel Lire wert
     */
    private static double kurs = 1936.27;

    public double waehrungsBetrag() {
        return super.euroBetrag() * kurs;
    }
}