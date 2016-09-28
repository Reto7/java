package Fach_1_Java_Grundlagen.A4;

/**
 * Created by user on 31.08.2016.
 */
public class A_4_13_Println {
    public static void main(String[] args) {
        double x = 1.0, y = 2.5;
        System.out.println(x / y);
        System.out.println("x / y = " + (x / y));
        System.out.println(x + y);
        System.out.println("x + y = " + x + y);
        System.out.println(x - y);
        System.out.println("x - y = " + (x - y));
        System.out.println(1 + 2 + 3 + 4);
        System.out.println(1 + 2 + 3 + "4");
        System.out.println("1" + 2 + 3 + 4);
        System.out.println("Hilfe" + true + 3);
        System.out.println(true + (3 + "Hilfe"));

        double z = 10E20;
        System.out.println(z);
    }
}
