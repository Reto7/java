package Fach_1_Java_Grundlagen.A4;

/**
 * Created by user on 02.09.2016.
 * Dieses Programm führt Berechnungen durch, die bei der Herstellung von Konservendosen
 aus einem Blechstück
 */
public class A_4_15_Raviolita_Buechsenberechnung {

    public static void main (String[] args) {
        final double PI = 3.141592;
        double u, h;
        u = 40; // Umfang der Dose in Zentimetern)
        h = 15; // Hoehe

        // durchmesser dosenboden
        double dBoden = u /PI;
        System.out.println("durchmesser dosenboden: " + dBoden);

        // flaeche dosenboden
        double fBoden = PI * Math.pow(dBoden/2,2);
        System.out.println("flaeche dosenboden: " + fBoden);

        // flaeche dose
        double fMantel = u*h;
        System.out.println("mantelfl. dose " + fMantel);

        // gesamtflaeche dose
        double fGesamt = (2 * fBoden) + fMantel;
        System.out.println("gesamtflaeche dose " + fGesamt);





    }

}