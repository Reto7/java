package Fach_1_Java_Grundlagen.Kaufmann;

/**
 * Created by rk on 15.09.16.
 */
public class A7 {
    public static void main(String[] args) {

        int[] intArray = new int[3];  // komp.Fehler String
        intArray[0] = 23;             // komp.Fehler array ab 0
        intArray[1] = 78;
        intArray[2] = 90;
        for (int i = 0; i < intArray.length; i++) {  // komp.Fehler
            System.out.println(intArray[i]);
        }

        /* Ausgabe:
            23
            78
            90
         */
    }
}
