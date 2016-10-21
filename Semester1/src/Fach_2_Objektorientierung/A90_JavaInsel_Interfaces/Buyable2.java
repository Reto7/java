package Fach_2_Objektorientierung.A90_JavaInsel_Interfaces;

/**
 * http://openbook.rheinwerk-verlag.de/javainsel/javainsel_05_013.html#dodtp4cdf05f9-ab55-4791-9fa2-c6929cc1a19d
 * <p>
 * Schnittstellen später zu ändern, wenn schon viele Klassen die Schnittstelle implementieren,
 * ist eine schlechte Idee. Denn erneuert sich die Schnittstelle, etwa wenn nur eine Operation
 * hinzukommt oder sich ein Variablentyp ändert, dann sind plötzlich alle implementierenden
 * Klassen kaputt. Sun selbst hat diesen Fehler bei der Schnittstelle java.sql.Connection gemacht.
 * Beim Übergang von Java 5 auf Java 6 wurde die Schnittstelle erweitert, und keine
 * Treiberimplementierungen konnten mehr compiliert werden. Die übliche Lösung für das Problem ist,
 * eine neue Schnittstelle mit weiteren Operationen einzuführen, die die alte Schnittstelle
 * erweitert, aber auf 2 endet. java.awt.LayoutManager2 ist so ein Beispiel aus dem Bereich
 * der grafischen Oberflächen, Attributes2, EntityResolver2, Locator2 für XML-Verarbeitung
 * sind weitere.
 *
 * TEST KLASSE siehe H:\DATEN\Intellij-Workspace\Semester1\test\Fach_2_Objektorientierung\A90_JavaInsel_Interfaces\BuyableTest.java
 */
public interface Buyable2 extends Buyable{

    int MAX_PRICE = 10000000;

    // eine statische Methode calculateSum(), die den Preis einer Sammlung zum Verkauf
    // stehender Objekte berechnet.

    // Die Methode nimmt käufliche Dinge an, wobei es ihr völlig egal ist, um welche es
    // sich dabei handelt. Was zählt, ist die Tatsache, dass die Elemente die Schnittstelle
    // Buyable2 implementieren.
    static double calculateSum( Buyable2[] prices)
    {
        double result = 0.00;
        for ( Buyable2 price : prices )
            result += price.price();
        return result;
    }


}
