package Fach_1_Java_Grundlagen.A4;

/**
 * Created by rk on 30.08.16.
 */
public class TestWhile {
    public static void main(String[] args) {

        int i = 20;
        while (i>0) {
            System.out.println(i);
            i -= 2; //2er Schritte minus
        }

        for (int y = 20; y > 0; y -=2 ) {
            System.out.println(y);
        }
    }
}
