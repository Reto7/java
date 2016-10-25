package Fach_2_Objektorientierung.A10_Exceptions.reto.exceptions;

/*

Aufgabe 10.5

Stellen Sie sich vor, Sie wollen an einer Stelle Ihres Programms alle möglichen
auftretenden Exceptions und RuntimeExceptions behandeln. Welche von
beiden Ausnahmen müssen Sie zuerst abfangen – die vom Typ Exception oder
die vom Typ RuntimeException?

==> Unbedingt die RuntimeException. Diese ist die Subklasse von Exception.
    Falls man Exception zuerst catchen wuerde, dann kommt RuntimeException nie mehr zum Zuge
    (wobei IntelliJ reklamieren wuerde ....has already been catched... oder so etwas)
 */
public class Aufgabe_10_5_ExceptionReihenfolge {

    public static void main (String[] args) {
        try {
            // mache irgendwas
        }
        catch (RuntimeException ex) {
            System.out.println( "RuntimeException abgefangen!" );
        }
        catch (Exception ex) {
            System.out.println( "Exception abgefangen! " );
        }


    }
}
