package Fach_2_Objektorientierung.A90_Vererbung;

/**
 * Created by rk on 04.10.16.
 */
public class DMtest {
    public static void main(String[] args) {
        DM a = new DM(2);
        System.out.println("DM: " + a.waehrungsBetrag());
        System.out.println("EURO: " + a.euroBetrag());
    }
}
