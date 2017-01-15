package Fach_1_Java_Grundlagen.A6;

/**
 * Created by rk on 13.09.16.
 */
public class MyMathMain {
    public static void main(String[] args) {
        double x = 12.0;
        double tan = MyMath.berechneTangens(x);
        System.out.println("Tangens von " +x +" ist " +tan);
        System.out.println("Gegencheck: " +Math.tan(x));
    }




}
