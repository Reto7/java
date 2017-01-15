package Fach_1_Java_Grundlagen.A4;
/**
 * Created by user on 04.09.2016.
 */

import Prog1Tools.IOTools;

public class A_4_33_Weihnachtsbaum {
    public static void main(String[] args) {

        int reihen = IOTools.readInt("Wie hoch soll der Weihnachtsbaum sein (Zahl) ? : ");

        int sterne = -1;
        char stern = '*';
        int leerzeichen = 0;

            for (int r = 1; r<=reihen; r++) {
                System.out.println();
                sterne=sterne+2;

                // leerzeichen (jede reihe ein leerzeichen dazugeben)
                // von der hoechsten reihenzahl die aktuelle reihenzahl abziehen
                leerzeichen = reihen-r;
                //System.out.println("leerzeichen einzusetzen: " + leerzeichen);
                for (int l = 0; l<leerzeichen; l++) {
                    System.out.print(" ");
                }

                // sterne
                for (int i = 0; i<sterne; i++) {
                    System.out.print(stern);
                }
            }

        // sterne enthaelt aktuell die anzahl sterne aus der letzten reihe, einfach halbieren
        System.out.println();
        for (int s = 0; s < sterne/2; s++) {
            System.out.print(" ");
        }
        System.out.println("I");
    }

}
