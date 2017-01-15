package Fach_1_Java_Grundlagen.A4; /**
 * Created by user on 03.09.2016.
 */
import Prog1Tools.IOTools;

public class A_4_20_Algorithmus {
    public static void main(String[] args) {
        int n = IOTools.readInt("Bitte Zahl eingeben");

        for (int i = 3; i < (2*n); i ++) {
            System.out.println(1.0/ ((2*i) +1) );
        }



    }
}
