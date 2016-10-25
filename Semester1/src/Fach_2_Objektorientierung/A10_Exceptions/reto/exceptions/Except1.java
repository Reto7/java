package Fach_2_Objektorientierung.A10_Exceptions.reto.exceptions;

import Prog1Tools.IOTools;
/**
 * Beispiel mit Division durch 0
 */
public class Except1 {

    public static void main(String[] args) {

        try {
            int a = 5; //IOTools.readInteger("a=");
            int b = 0; //IOTools.readInteger("b=");
            System.out.println("a/b=" + (a / b));
        } catch (ArithmeticException ex) {
            System.out.println("Fehler: " +ex.getMessage());
            System.out.print("Stacktrace: ");
            ex.printStackTrace();
        } finally {
            System.out.println("finally wird IMMER ausgefuehrt");
            // z.B. bei File-Operationen die DATEI AM SCHLUSS SCHLIESSEN
        }
    }
}
