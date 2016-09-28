package Fach_1_Java_Grundlagen.A4;

/**
 * Created by user on 02.09.2016.
 */
public class Schleifen {
    public static void main(String[] args) {

        System.out.println("------------------------");
        // 0-9
        for (int i=0; i<10; ++i){
            System.out.println(i);
        }
        System.out.println("------------------------");
        // 0-9  weshalb fängt er hier nicht bei 1 an (wegen ++i) ?
        for (int i=0; i<10; ++i){
            System.out.println(i);
        }

        System.out.println("------------------------");
        int w = 0;
        while(w < 10) {
            System.out.println(w);
            w++;
        }

        System.out.println("------------------------");
        int d = 0;
        do {
            System.out.println(d);
            d++;
        } while (d<10);

        System.out.println("------------------------");
        System.out.println("Endlos Loop");
        marke:
        for (int i=1; true ; i++) {
            System.out.println(i);
            if (i == 100) {
                break marke;
            }
        }

        System.out.println("------------------------");
        if (1 == 0) {
            System.out.println(false);
        } else if (1==2) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }

        System.out.println("------------------------");
        // furchtbar!!
        int a = 1, b;
        switch (a) {
            case 1:
                b = 10;
            case 2:
            case 3:
                b = 20;  // b wird hier mit 20 ueberschrieben!!
                break;
            case 4:
                b = 30;
                break;
            default:
                b = 40;
        }
        System.out.println(b);

        System.out.println("------------------------");
        //Hier wird durch die Verwendung von continue vermieden, dass eine ganzzahlige
        //Division durch Null durchgefuhrt wird.
        for (int i=-10; i<=10; i++){
             if (i == 0)
                 continue;
             System.out.println ("Division von 1 durch " + i +
                     " ergibt " + 1/i);
             }


        // A 4_17
        for (int i = 20; i > 0; i -=2 ) {
            System.out.println(i);
        }


    }
}
