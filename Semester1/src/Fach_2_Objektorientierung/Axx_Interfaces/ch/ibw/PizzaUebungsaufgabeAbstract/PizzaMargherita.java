package Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeAbstract;

import Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaInterface;

/**
 * Pizza Margherita hat zusaetzliche Zutataen
 * wird in versch. Groessen angeboten
 *
 *  Siehe Testklassen
 *
 */
public class PizzaMargherita extends PizzaAbstract {

    private String[] zutaten = {"Teig", "Kaese", "Tomatensauce"};
    private String groesse;

    @Override
    public double getPreis() {
        if (this.groesse != null) {
            if (this.groesse.equals("klein")) {
                return PizzaInterface.BASISPREIS;
            } else if (this.groesse.equals("mittel")) {
                return PizzaInterface.BASISPREIS * 2;
            } else if (this.groesse.equals("gross")) {
                return PizzaInterface.BASISPREIS * 3;
            } else return 0.00; //
        }
        else return 0.00;
    }


    // speziell nuer fuer margherita
    public String getGroesse() {
        return groesse;
    }

    public void setGroesse(String groesse) {
        if (groesse.equals("klein") || groesse.equals("mittel")  || groesse.equals("gross")) {
            this.groesse = groesse;
        } else {
            System.out.println("Groesse muss 'klein', 'mittel' oder 'gross' sein");
        }
    }
}
