package Fach_2_Objektorientierung.A90_Interfaces_Delegate_Pattern;

/**
 * http://www.programmierenlernenhq.de/einfuehrung-in-java-design-patterns-software-entwurfsmuster/
 * -----------------------------------------------------------------------------
 * Die ganze Loesung wird so erweiterbar. Neue Printer muessen einfach nur das
 * Printable Interface implementieren!
 * Es muss weder Printer noch Printable angepasst werden
 * -----------------------------------------------------------------------------
 */
class Printer // Delegator!
{
    // Referenz auf Interface! BlackWhitePrinter und ColorPrinter SIND ja Printable
    Printable actualPrinter;

    // Constructors
    public Printer () {
        // per default ein BlackWhitePrinter (wenn nichts uebergeben wurde)
        actualPrinter = new BlackWhitePrinter();
    }
    public Printer(Printable curentPrinter) {
        actualPrinter = curentPrinter;
    }

    // Methoden
    public void print()
    {
        // ruft die print-Methode von BlackWhitePrinter oder ColorPrinter auf
        // dieser Aufruf erfolgt dynamisch, je nachdem welches Objekt
        // in der Referenzvariable actualPrinter gerade gespeichert ist
        actualPrinter.print();  // delegation
    }

    public void switchTo(Printable otherPrinter)
    {
        actualPrinter = otherPrinter;
    }
}