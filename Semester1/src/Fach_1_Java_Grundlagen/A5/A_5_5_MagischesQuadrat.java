package Fach_1_Java_Grundlagen.A5;

import Prog1Tools.IOTools;

/**
 * Created by user on 11.09.2016.
 */
public class A_5_5_MagischesQuadrat {
    public static void main(String[] args) {
        /*
        3  16  9 22 15
        20  8 21 14  2
        7  25 13  1 19
        24 12  5 18  6
        11  4 17 10 23
        */

        int n = 0;
        while(n<=2 || n>=10 || n%2==0) {
            n = IOTools.readInt("Bitte Zahl eingeben 3-9, ungerade: ");
        }

        int[][] quad = new int[n][n];
        int zeile = (int) n / 2;            //   5/2    = 2
        int spalte= (int) (n / 2)+1;        //   5/2 +1 = 3
        for (int i=1; i<=n*n; i++) {
            quad[zeile][spalte] = i;
            // Erhöhen Sie spalte um 1, erniedrigen Sie zeile um 1.
            spalte++;
            zeile--;
            if (zeile<0) {
                zeile = n-1;
            }
            if (spalte == n) {
                spalte=0;
            }
            if (quad[zeile][spalte] != 0) {
                zeile++;
                spalte++;
                if (zeile == n) {
                    zeile = 0;
                }
                if (spalte == n) {
                    spalte = 0;
                }
            }
        }

        // Ausgabe
        for (int zeilenAusabe=0; zeilenAusabe<n; zeilenAusabe++) {
            System.out.println();
            for (int spaltenAusgabe=0; spaltenAusgabe<n; spaltenAusgabe++){

                // optik
                if (quad[zeilenAusabe][spaltenAusgabe] < 10) {
                    System.out.print("   " +quad[zeilenAusabe][spaltenAusgabe] );
                } else {
                    System.out.print("  "  +quad[zeilenAusabe][spaltenAusgabe] );
                }

            }


        }

    }
}
