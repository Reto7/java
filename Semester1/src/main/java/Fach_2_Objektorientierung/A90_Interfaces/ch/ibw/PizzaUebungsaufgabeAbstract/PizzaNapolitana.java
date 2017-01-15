package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeAbstract;

import Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaInterface;

/**
 * Pizza Napolitana hat zusaetzliche Zutataen
 * wird aber nur in einer Groesse angeboten
 *
 *  Siehe Testklassen
 *
 */
public class PizzaNapolitana extends PizzaAbstract {

    private String[] zutaten = {"Teig", "Kaese", "Tomatensauce", "Salami"};

    @Override
    public double getPreis() {
        return PizzaInterface.BASISPREIS + PizzaInterface.ZUTAT_SALAMI_PREIS;
    }
}
