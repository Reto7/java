package Fach_1_Java_Grundlagen.A4;

/**
 * Created by rk on 30.08.16.
 */
public class Schachbrett {
    public static void main(String[] args) {
        for (int zeile = 1; zeile <= 8; zeile++) {
            System.out.println("");
            for (int h = 0; h < 8; h++){
                int o = zeile+h;

                //CAST int to String
                //String output = String.valueOf(o);

                if (o < 10) {
                    System.out.print("  ");
                } else
                {
                    System.out.print(" ");
                }

                //System.out.print("\t");   // Tabulator
                System.out.print(o);
            }
        }
    }
}
