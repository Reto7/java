package Fach_2_Objektorientierung.A9;

/**
 * Created by rk on 04.10.16.
 */

public class DM extends Euro {

    /**
     * Konstruktor EINGABE DM, gleich in Euro gehen
     */
    public DM(double x) {
        super(x / kurs);  //Wert des Geldbetrags in Euro
    }

    /**
     * Konstruktor, kann hierbei EURO, DM, LIRE empfangen (den DM ist ja auch EURO)
     */
    public DM(Euro e) {
        super(e.euroBetrag());  //Wert des Geldbetrags in Euro
    }

    /**
     * Ein Euro ist soviel DM wert
     */
    private static double kurs = 1.95583;

    public double waehrungsBetrag() {
        return super.euroBetrag() * kurs;
    }
}