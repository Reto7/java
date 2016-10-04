package Fach_2_Objektorientierung.A9;

/**
 * Created by rk on 04.10.16.
 */

public class Lire extends Euro {
    /**
     * Ein Euro ist soviel Lire wert (definitiv fixiert, aendert nie mehr)
     */
    private static final double KURS = 1936.27;

    /**
     * Konstruktor EINGABE LIRE, , gleich in Euro gehen
     */
    public Lire(double x) {
        super(x / KURS);  //Wert des Geldbetrags in Euro
    }

    /**
     * Konstruktor, kann hierbei EURO, DM, LIRE empfangen (den DM ist ja auch EURO)
     */
    public Lire(Euro e) {
        super(e.euroBetrag());  //Wert des Geldbetrags in Euro
    }

    public double waehrungsBetrag() {
        return super.euroBetrag() * KURS;
    }
}