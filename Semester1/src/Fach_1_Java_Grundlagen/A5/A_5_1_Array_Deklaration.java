package Fach_1_Java_Grundlagen.A5;

/**
 * Created by user on 11.09.2016.
 */
public class A_5_1_Array_Deklaration {

    // tage und stunden
    String[][] termine = new String[31][24];

    // Aufgabe 5.1.a
    // Bei der Deklaration werden durch Angabe des Komponententyps und der Dimensionsanzahl (Anzahl der leeren Klammerpaare)
    // lediglich die Variablen angelegt, die als Referenzen auf die Feldobjekte dienen.
    // Erst bei der Erzeugung wird der durch die Feldvariable referenzierte Speicherplatz bereitgestellt.

    // Aufgabe 5.1.b
    int[] v1 = new int[2];
    int[] v2 = {1,2};
    int[] v3 = new int[]{1,2}; // Kombination aus v1 und v2 (ohne Angabe der Arraylänge in []!)

    // Aufgabe 5.1.c
    byte a , b;
    byte[] aReihe, aZeile, bReihe, bZeile;
    byte[][] aMatrix, bMatrix;
}
