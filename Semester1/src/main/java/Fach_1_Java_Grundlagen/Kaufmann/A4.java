package Fach_1_Java_Grundlagen.Kaufmann;

/**
 * Created by rk on 15.09.16.
 */
public class A4 {
    public static void main(String[] args) {

        int note = 3;

        if (note >= 1 && note < 4) {
            System.out.println("Ungenügend");
        } else if (note >=4 ) {
            System.out.println("Bestanden");
        }
        else {
            System.out.println("FEHLER, ausserhalb Notenskala");
        }
    }
}
