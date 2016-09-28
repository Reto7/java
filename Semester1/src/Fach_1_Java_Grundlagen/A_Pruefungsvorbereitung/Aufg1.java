package Fach_1_Java_Grundlagen.A_Pruefungsvorbereitung;

import Prog1Tools.IOTools;


/**
 * (IOTools wird an der Pruefung nicht verwenden. Nur einfache int Zuweisungen.
 * Ziel: 10 bis 15 Min.
 *
 1. Lies den Wert von n ein.
 2. Setze i auf 3.
 3. Solange i < 2n, wiederhole:
    Erhöhe i um 1
    Gib 1 / (2i+1) aus
 *
 */
public class Aufg1 {

    public static void main(String[] args) {
        double d;
        int n = IOTools.readInt("Bitte Zahl eingeben : ");
        for (int i = 3; i<(2*n); i++) {
            d = (double)1 / ((2*i) +1);
            System.out.println(d);
        }
    }

}
