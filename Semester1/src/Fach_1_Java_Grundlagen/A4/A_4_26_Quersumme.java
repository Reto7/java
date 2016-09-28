package Fach_1_Java_Grundlagen.A4;
import Prog1Tools.IOTools;

/**
 * Created by user on 03.09.2016.
 */
public class A_4_26_Quersumme {

    //Schreiben Sie ein Java-Programm, das eine int-Zahl z mit 0 < z < 10000 einliest,
    //ihre Quersumme berechnet

    public static void main(String[] args) {

        int zahl = 0;
        int querSumme;
        int aktuelleZiffer;

        // eingegebene Zahl im zulaessigen Bereich?
        while ( zahl < 1 || zahl > 9999 ) {
            System.out.println( "Zahlen kleiner 1 und groesser 9999 nicht zugelassen!" );
            zahl = IOTools.readInteger( "Positive ganze Zahl eingeben: " );
        }

        System.out.println( "\nDie Quersumme ergibt sich zu: " );
        querSumme = 0;

        while ( zahl != 0 ) {

            aktuelleZiffer = zahl % 10;  // letzte Ziffer auslesen
            zahl           = zahl / 10;  // letzte Ziffer abschneiden
            querSumme     += aktuelleZiffer;
            System.out.print( aktuelleZiffer  );
            if ( zahl != 0 ) System.out.print( " + " ); // nach 'letzter' (eigentlich: erster) Ziffer darf kein '+' ausgegeben werden
        }

        System.out.println( " = " + querSumme );
    }
}