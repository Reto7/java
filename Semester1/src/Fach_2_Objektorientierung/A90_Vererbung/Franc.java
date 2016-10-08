package Fach_2_Objektorientierung.A90_Vererbung;

/**
 * Created by rk on 04.10.16.
 */

public class Franc extends Euro {
    /**
     * Ein Euro ist soviel Franc wert (definitiv fixiert, aendert nie mehr)
     */
    private static final double KURS = 6.55957;

    /**
     * Konstruktor EINGABE FRANC, gleich in Euro gehen
     */
    public Franc(double x) {

        super(x / KURS);  //Wert des Geldbetrags in Euro
    }

    /**
     * Konstruktor, kann hierbei EURO, DM, LIRE empfangen (den DM ist ja auch EURO)
     */
    public Franc(Euro e) {

        super(e.euroBetrag());  //Wert des Geldbetrags in Euro
    }



    public double waehrungsBetrag() {
        return super.euroBetrag() * KURS;
    }
}