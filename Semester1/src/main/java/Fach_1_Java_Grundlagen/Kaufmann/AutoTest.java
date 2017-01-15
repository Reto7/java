package Fach_1_Java_Grundlagen.Kaufmann;

/**
 * Created by rk on 15.09.16.
 */
public class AutoTest {
    public static void main(String[] args) {

        Auto passat = new Auto();
        passat.autoMarke = "VW";
        passat.anzahlTueren = 5;
        passat.ps = 140;

        Auto golf = new Auto();
        golf.autoMarke = "VW";
        golf.anzahlTueren = 4;
        golf.ps = 160;

        Auto smax = new Auto();
        smax.autoMarke = "Ford";
        smax.anzahlTueren = 5;
        smax.ps = 90;

        // Test
        System.out.println("Automarke Golf ist: " +golf.autoMarke);
    }


}
