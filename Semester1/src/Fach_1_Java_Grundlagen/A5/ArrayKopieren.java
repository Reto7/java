package Fach_1_Java_Grundlagen.A5;

/**
 * Created by user on 10.09.2016.
 */
public class ArrayKopieren {
    public static void main(String[] args) {
        String[] liste1 = {"A","B","C"};
        System.out.println("Länge Liste 1: " +liste1.length + "  |  Wert 2: " + liste1[2]);

        // 1. Manuell Kopieren
        String[] liste2 = new String[liste1.length];
        for (int i = 0; i<liste1.length; i++) {
            liste2[i] = liste1[i];
        }
        // mutation wert aus alter liste
        liste1[2] = "Verändert 1";
        System.out.println("Länge Liste 1: " +liste1.length + "  |  Wert 2: " + liste1[2]);
        System.out.println("Länge Liste 2: " +liste2.length + "  |  Wert 2: " + liste2[2]);


        // Kopiermethode
        String[] liste3 = new String[liste1.length];
        //System.arraycopy(≪QUELLE≫,≪QUELLSTARTINDEX≫,
        //                  ≪ZIEL≫ ,≪ZIELSTARTINDEX≫,
        //                  ≪ANZAHL≫);
        System.arraycopy(liste2,0,liste3,0,liste1.length);
        // mutation wert aus alter liste
        liste2[2] = "Verändert 2";
        System.out.println("Länge Liste 2: " +liste2.length + "  |  Wert 2: " + liste2[2]);
        System.out.println("Länge Liste 3: " +liste3.length + "  |  Wert 2: " + liste3[2]);


    }

}
