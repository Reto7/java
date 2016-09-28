package Fach_1_Java_Grundlagen.A5;

/**
 * Created by user on 06.09.2016.
 */
public class Array2 {
    public static void main(String[] args) {
        int[] intListe = new int[10];
        intListe[3] = 155;
        System.out.println("pos 4: " + intListe[3]);
        System.out.println("pos 5: " + intListe[4]);

        //java.lang.ArrayIndexOutOfBoundsException:
        //System.out.println("pos 100: " + intListe[99]);

        //java.lang.ArrayIndexOutOfBoundsException:
        //intListe[99] = 777;

        int[] intArray = { 1 , 6 , 4 , 7 , 8 };
        double[] doubleArray = {3.14 , -276.06 };
        String[] stringArray= {"Hallo"
                ,   "dies"
                ,   "ist ein"
                ,   "Feld"};


        // array deklarieren und initialisieren
        int[] intArray2 = new int[5];
        // mittels schleife fuellen
        for (int i = 0; i < 5; i++) {
            intArray[i] = i+1;
        }
        System.out.println("Länge des Array: "+intArray2.length);

    }
}
