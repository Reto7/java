package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeAbstract;

/**
 * Created by user on 16.10.2016.
 */
public abstract class PizzaAbstract {

    // Abstrakte Klassen koennen Attribute haben
    private String zutaten[];
    private Double preis;

    // jede pizza kostet mindestens diesen preis (noch ohne zutaten)
    public static final double BASISPREIS = 10.0;
    // hier die zutaten-preise
    public static final double ZUTAT_SALAMI_PREIS = 2.00;
    public static final double ZUTAT_PILZE_PREIS = 1.50;
    public static final double ZUTAT_SCHARFE_SAUCE_PREIS = 1.00;

    //--------------------------------------------------------------------------------------
    // Abstrakte Methoden koennen von den Kindern ueberschrieben werden, muessen aber nicht!
    //--------------------------------------------------------------------------------------

    // jede Pizza hat versch. Zutaten, muss also selber wissen welche
    // um welche Zutaten es geht, verwaltet jedes Kind dann selber in dem
    // "zutaten" Attribut, deshalb kann die Methode selbest hier zentral
    // gefuehrt werden!
    // getZutaten ist von der Syntax her in jeder Kindklasse genau gleich!
    public String[] getZutaten() {
        return zutaten;
    }

    // ohne body, da abstract
    // jede Pizza hat einen anderen preis, muss also selber wissen welchen
    // die Preisberechung ist in jeder Kindklasse voellig anders!
    public abstract double getPreis();

}
