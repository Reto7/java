package Fach_1_Java_Grundlagen.A5;
import Prog1Tools.IOTools;

/**
 * Created by user on 06.09.2016.
 */
public class ArrayAdressbuch {
    public static void main(String[] args) {
        final int anzahlTermine = 24;

        // fuer jede Stunde
        String[] termine = new String[anzahlTermine];

        // init mit leerem String
        for (int i=0; i<termine.length; i++) {
            termine[i] = "";
        }


        int auswahl = 0;
        while (auswahl != 3) {
            System.out.println(" ");
            System.out.println("1 = Neuer Eintrag");
            System.out.println("2 = Termine ausgeben");
            System.out.println("3 = Programm beenden");
            auswahl = IOTools.readInteger("Ihre Wahl:");
            // Nun eine Fallunterscheidung
            switch (auswahl) {
                case 1: // Termine eingeben

                    break;
                case 2: // Termine ausgeben

                    break;
                case 3: // Programm beenden
                    break;
                default: // Falsche Zahl eingegeben
                    System.out.println("falsche Zahl eingegeben");
            }
        }


    }
}
