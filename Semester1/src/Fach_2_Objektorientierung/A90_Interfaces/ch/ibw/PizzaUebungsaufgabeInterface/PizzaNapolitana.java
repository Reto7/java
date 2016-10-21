package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface;

/**
 * Pizza Napolitana hat zusaetzliche Zutataen
 * wird aber nur in einer Groesse angeboten
 *
 *  Siehe Testklassen
 *
 */
public class PizzaNapolitana implements PizzaInterface {

    private String[] zutaten = {"Teig", "Kaese", "Tomatensauce", "Salami"};

    @Override
    public String[] getZutaten() {
        return zutaten;
    }

    @Override
    public double getPreis() {
        return BASISPREIS + ZUTAT_SALAMI_PREIS;
    }
}
