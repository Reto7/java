package Fach_1_Java_Grundlagen.Kaufmann;

/**
 * Created by rk on 15.09.16.
 */
public class A6 {
    public static void main(String[] args) {

        int summer = 0;
        int lowerBand = 1;
        int upperBand = 100;
        int resultat = 0;
        for (int i = lowerBand; i <= upperBand; i++) {
            summer++;
            resultat = resultat + summer;
        }
        System.out.println("Summe von "+lowerBand +" bis " +upperBand +" : " + resultat);
    }
}
