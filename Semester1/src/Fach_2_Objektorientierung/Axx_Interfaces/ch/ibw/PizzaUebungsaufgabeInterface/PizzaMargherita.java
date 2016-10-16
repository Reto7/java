package Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface;

/**
 * Pizza Margherita hat zusaetzliche Zutataen
 * wird in versch. Groessen angeboten
 *
 *  Siehe Testklassen
 *
 */
public class PizzaMargherita implements PizzaInterface {

    private String[] zutatenListe = {"Teig", "Kaese", "Tomatensauce"};
    private String groesse;

    @Override
    public String[] getZutaten() {
        return zutatenListe;
    }

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
