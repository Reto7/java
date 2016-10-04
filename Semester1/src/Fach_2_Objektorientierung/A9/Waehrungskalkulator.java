package Fach_2_Objektorientierung.A9;

import Prog1Tools.IOTools;

/**
 * Created by rk on 04.10.16.
 */
public class Waehrungskalkulator {
    public static void main(String[] args) {
        double dmBetrag = IOTools.readDouble("DM Betrag > ");

        DM dm = new DM(dmBetrag);
        System.out.println(" DM in DM: " + dm.waehrungsBetrag());
        System.out.println(" DM in EURO: " + dm.euroBetrag());

        Lire l = new Lire(dm);
        System.out.println(" DM in Lire: " + l.waehrungsBetrag());
        System.out.println("(Lire in EURO: " + l.euroBetrag() + ")");

      //Franc f = new Franc(new Euro(dm.euroBetrag()));
        Franc f = new Franc(dm);
        System.out.println(" DM in Franc: " + f.waehrungsBetrag());
        System.out.println("(Franc in EURO: " + f.euroBetrag() + ")");
    }

}
