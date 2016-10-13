package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.interfaces;

/**
 * Interface aehnlich einer abstrakten Klassen, aber wie "mehrfach vererbbar"
 *
 * Interfaces enthalten ausschließlich Konstanten und abstrakte Methoden.
 * Die abstrakten Methoden müssen von der Klasse implementiert werden, der das Interface zugewiesen wird.
 *
 * Schnittstellen sind eine gute Ergänzung zu abstrakten Klassen/Methoden.
 * Denn im objektorientierten Design wollen wir das Was vom Wie trennen.
 * Abstrakte Methoden sagen wie Schnittstellen etwas über das Was aus, aber erst die konkreten Implementierungen realisieren das Wie
 */
public interface InterfaceBase {



    public void print();
}
