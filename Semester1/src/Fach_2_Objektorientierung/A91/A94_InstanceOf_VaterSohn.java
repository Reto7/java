package Fach_2_Objektorientierung.A91;

/**
 * Created by rk on 08.10.16.
 * Seite 265
 */

class Vater {};
class Sohn extends Vater{};

public class A94_InstanceOf_VaterSohn {




    public static void main(String[] args) {
/* Unterscheiden ob ein Objekt Instanz einer bestimmten Klasse ist.
Hierzu existiert in Java der Operator instanceof.
Die Abfrage obj instanceof Waehrung
liefert genau dann true, wenn das Objekt obj Instanz der
Klasse Waehrung (oder einer ihrer Subklassen) ist.
*/
        Vater vaeterchen = new Vater();
        Sohn soehnchen = new Sohn();
        System.out.println(vaeterchen instanceof Sohn);     //false
        System.out.println(vaeterchen instanceof Vater);    //true
        //System.out.println(vaeterchen instanceof Waehrung); //inconvertible types
        System.out.println(vaeterchen instanceof Object);   //true
        System.out.println(soehnchen instanceof Sohn);      //true
        System.out.println(soehnchen instanceof Vater);     //true
        // System.out.println(soehnchen instanceof Waehrung);  //inconvertible types
        System.out.println(soehnchen instanceof Object);    //true

    }

}
