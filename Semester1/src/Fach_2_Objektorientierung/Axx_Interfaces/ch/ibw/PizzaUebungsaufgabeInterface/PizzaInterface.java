package Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface;

/**
 *  Siehe Testklassen
 */
public interface PizzaInterface {

    // Interfaces haben keine Attribute, nur Methoden!
    // private String zutaten[];
    // private Double preis;

    // jede pizza kostet mindestens diesen preis (noch ohne zutaten)
    public static final double BASISPREIS = 10.0;
    // hier die zutaten-preise
    public static final double ZUTAT_SALAMI_PREIS = 2.00;
    public static final double ZUTAT_PILZE_PREIS = 1.50;
    public static final double ZUTAT_SCHARFE_SAUCE_PREIS = 1.00;

    public String[] getZutaten();
    public double getPreis();

}
