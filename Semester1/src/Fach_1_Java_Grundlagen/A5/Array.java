package Fach_1_Java_Grundlagen.A5;

/**
 * Created by user on 06.09.2016.
 */
public class Array {
    public static void main(String[] args) {
        // fixe laenge
        // Zugriff auf die Elemente über den Array-Index (beginnt bei 0)
        String[] stringListe = new String[5];
        // An der 3. Stelle einen String hinzufuegen
        stringListe[2] = "Hallo";

        System.out.println("pos 2 : " + stringListe[2]);
        System.out.println("pos 2 : " + stringListe[3]);


        // direkt initialisieren
        int[] squares = {1, 2, 4, 9, 16};
        String[] liste = {"A","B","C"};
    }
}
