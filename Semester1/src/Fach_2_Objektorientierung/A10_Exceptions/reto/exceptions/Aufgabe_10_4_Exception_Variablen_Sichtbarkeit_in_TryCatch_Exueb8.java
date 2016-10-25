package Fach_2_Objektorientierung.A10_Exceptions.reto.exceptions;

/**
 * Aufgabe 10.4
 */
public class Aufgabe_10_4_Exception_Variablen_Sichtbarkeit_in_TryCatch_Exueb8 {
    /**
     * Bestimme eine Zufallszahl zwischen 0 und 0.5
     */
    public static double gibZufallszahlBisEinhalb() throws Exception {
        double res = Math.random();
        if (res > 0.5)
            throw new Exception("Zahl zu gross");
        return res;
    }

    /**
     * Hauptprogramm
     */
    public static void main(String[] args) {
        // muss hier ausserhalb des try/catch deklariert werden
        double zahl;
        // Bestimme eine Zufallszahl zwischen 0 und 0.5
        try {
            zahl = gibZufallszahlBisEinhalb();
        }
        // Falls etwas schief geht (Exception)
        // verwende die Zahl 0.5
        catch (Exception e) {
            System.out.println("         .....korrigiert auf 0.5");
            zahl = 0.5;
        }

        // gib die Zahl auf dem Bildschirm aus
        System.out.println(zahl);
    }
}

