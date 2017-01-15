package Fach_1_Java_Grundlagen.Kaufmann;

/**
 * Created by rk on 15.09.16.
 */
public class A8 {
    public static void main(String[] args) {

        boolean[] bArray = new boolean[4];
        bArray[0] = true;
        bArray[1] = false;
        bArray[2] = true;
        bArray[3] = false;

        for (boolean b : bArray) {
            if(b) {
                System.out.println("Wahr");
            } else {
                System.out.println("Falsch");
            }
        }

    }
}
