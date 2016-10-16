package Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface;

/**
 * Pizza Napolitana hat zusaetzliche Zutataen
 * wird aber nur in einer Groesse angeboten
 *
 *  Siehe Testklassen
 *
 */
public class PizzaNapolitana implements PizzaInterface {

    private String[] zutatenListe = {"Teig", "Kaese", "Tomatensauce", "Salami"};

    @Override
    public String[] getZutaten() {
        return zutatenListe;
    }

    @Override
    public double getPreis() {
        return PizzaInterface.BASISPREIS + PizzaInterface.ZUTAT_SALAMI_PREIS;
    }
}
