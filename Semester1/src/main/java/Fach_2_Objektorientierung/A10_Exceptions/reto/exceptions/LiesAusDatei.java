package Fach_2_Objektorientierung.A10_Exceptions.reto.exceptions;

import Prog1Tools.IOTools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LiesAusDatei {
    public static void main(String[] args)
    {

        try {
            // Lies den Dateinamen ein:
            String dateiname = IOTools.readString("Dateiname: ");
            // Oeffne die Datei zum Lesen:
            FileReader dateileser = new FileReader(dateiname);
            // Lies alle Zeichen aus der Datei ein (read liefert int)
            // bis das Dateiende erreicht wird (signalisiert durch -1)
            // und gib sie (wieder als Buchstabe) auf den Bildschirm aus:
            System.out.println("In der Datei " + dateiname + " steht");
            while (true) {
                int gelesen = dateileser.read();
                if (gelesen == -1)
                    break;
                System.out.print((char) gelesen);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fehler: "+e.getMessage());
        } catch(IOException e) {
            System.out.println("Fehler: "+e.getMessage());
        }
    }
}