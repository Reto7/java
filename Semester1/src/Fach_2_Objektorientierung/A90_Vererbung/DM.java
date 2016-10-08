package Fach_2_Objektorientierung.A90_Vererbung;

/**
 * Created by rk on 04.10.16.
 */

public class DM extends Euro {
    /**
     * Ein Euro ist soviel DM wert (definitiv fixiert, aendert nie mehr)
     */
    private static final double KURS = 1.95583;

    /**
     * Konstruktor EINGABE DM, gleich in Euro gehen
     */
    public DM(double x) {
        super(x / KURS);  //Wert des Geldbetrags in Euro
    }

    /**
     * Konstruktor, kann hierbei EURO, DM, LIRE empfangen (den DM ist ja auch EURO)
     */
    public DM(Euro e) {
        super(e.euroBetrag());  //Wert des Geldbetrags in Euro
    }

    public double waehrungsBetrag() {
        return super.euroBetrag() * KURS;
    }
}