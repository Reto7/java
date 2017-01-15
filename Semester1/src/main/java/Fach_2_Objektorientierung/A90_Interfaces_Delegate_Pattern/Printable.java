package Fach_2_Objektorientierung.A90_Interfaces_Delegate_Pattern;

/**
 * http://www.programmierenlernenhq.de/einfuehrung-in-java-design-patterns-software-entwurfsmuster/
 * -----------------------------------------------------------------------------
 * Die ganze Loesung wird so erweiterbar. Neue Printer muessen einfach nur das
 * Printable Interface implementieren!
 * Es muss weder Printer noch Printable angepasst werden
 * -----------------------------------------------------------------------------
 */
interface Printable
{
    // alle Methoden in Interfaces sind implizit public und abstract
    // man könnte auch schreiben: "public abstract void print();"
    void print();
}