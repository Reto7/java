package Fach_2_Objektorientierung.A90_Interfaces_JavaInsel;

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
 * TEST KLASSE siehe H:\DATEN\Intellij-Workspace\Semester1\test\Fach_2_Objektorientierung\A90_Interfaces_JavaInsel\BuyableTest.java
 */
public interface Buyable
{
    public double price();
}