package Fach_1_Java_Grundlagen.A4;

/**
 * Created by user on 02.09.2016.
 */
public class Modulo_DivisionsRest {
        public static void main(String[] args) {


            //Der Divisionsrest in Java
            // 47 geteilt durch 10 gleich 4, Rest 7
            System.out.println("??: " + (47 % 10));

            System.out.println("0/9ist : " + (0 / 9));  //0
            System.out.println("0/9Rest: " + (0 % 9));  //0

            System.out.println("1/9ist : " + (1 / 9));  //0
            System.out.println("1/9Rest: " + (1 % 9));  //1

            System.out.println("18/9ist : " + (18 / 9));  //2
            System.out.println("18/9Rest: " + (18 % 9));  //0   so kann man ein Vielfaches von 9 gut erkennen, wenn DivisionsRest=0

            System.out.println("1/10ist : " + (1 / 10));  //0
            System.out.println("1/10Rest: " + (1 % 10));  //1
        }
}
