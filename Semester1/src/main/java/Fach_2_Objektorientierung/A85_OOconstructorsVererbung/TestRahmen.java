package Fach_2_Objektorientierung.A85_OOconstructorsVererbung;

/**
 * Created by rk on 27.09.16.
 */
public class TestRahmen {
    public static void main(String[] args) {

        /*
        super() muss immer die erste Anweisung im Konstruktor sein.
        Beim Aufbau neuer Objekte läuft die Laufzeitumgebung daher als Erstes die
        Hierarchie nach java.lang.Object ab und beginnt dort von oben nach unten
        mit der Initialisierung. Kommt der eigene Konstruktor an die Reihe, konnten
        die Konstruktoren der Oberklasse ihre Werte schon initialisieren.
        */

        System.out.println("------------START------------");
        new Hund();
        //Ausgabe:
        // Katze
        // Fuchs
        // Hund
        // Maus
        // Maus
        // Ratte

        //hier git test
    }
}