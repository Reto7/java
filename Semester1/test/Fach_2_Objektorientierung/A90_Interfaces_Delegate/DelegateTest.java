package Fach_2_Objektorientierung.A90_Interfaces_Delegate;

import org.junit.Test;

/**
 * http://www.programmierenlernenhq.de/einfuehrung-in-java-design-patterns-software-entwurfsmuster/
 * -----------------------------------------------------------------------------
 * Die ganze Loesung wird so erweiterbar. Neue Printer muessen einfach nur das
 * Printable Interface implementieren!
 * Es muss weder Printer noch Printable angepasst werden
 * -----------------------------------------------------------------------------
 */
public class DelegateTest
{
    @Test
    public void printerTest()
    {
        // ein BlackWhitePrinter
        Printer myPrinter = new Printer();
        myPrinter.print();
        // ein ColorPrinter
        myPrinter.switchTo(new ColorPrinter());
        myPrinter.print();
    }
}