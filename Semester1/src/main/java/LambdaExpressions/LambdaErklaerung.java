package LambdaExpressions;

import java.util.ArrayList;
import java.util.stream.Stream;



/**
 * Created by user on 01.10.2017.
 */
public class LambdaErklaerung {

    public void t1() {

        ArrayList<Point> pointList = new ArrayList<Point>();

        // In der klassischen imperativen Entwicklung arbeiten wir viel mit Bedingungen und
        // Schleifen. Dabei wird ständig das Was mit dem Wie vermischt, wie das folgende Beispiel zeigt:
        for (Point p : pointList) {
            if (p.isValid()) {
                p.translate(1, 1);
            }
        }
        //Die Wiederverwendung des Prädikats (p.isValid()) und der Transformation
        // (p.translate(1, 1)) ist nicht ohne weiteres möglich. Stattdessen sind
        // diese beiden Aufrufe mit dem Durchlauf der Schleife fest verknüpft.
        // Mit der Stream-API kann man das obige Beispiel aber nun auch folgendermaßen schreiben:

        //    Point p;
        //    pointList.stream()
        //            .filter(p::isValid())
        //        .each(p -> p.translate(1, 1));
    }


    public void t2() {
        //Lambda-Ausdrücke bestehen aus einer Parameterliste und dem Body,
        // die durch den sogenannten Function Arrow (->) getrennt werden.
        //Point p ->p.translate(1, 1);
        //p -> p.translate(1, 1);

        //Längere oder leere Parameterlisten müssen geklammert werden:
        //() -> System.out.println("Foo");
        //(String s) -> {System.out.println(s);}
        //(int x, int y) -> x+y;

    }


    public class Point {
        public boolean isValid() {
            return true;
        }

        public void translate(int i, int i1) {
        }
    }


}
