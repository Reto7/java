package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeAbstract;

import Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaInterface;
import Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaMargherita;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 16.10.2016.
 */
public class PizzaTestUebungsaufgabe {

    // Assertion auf DOUBLE
    //java.lang.AssertionError: Use assertEquals(expected, actual, delta) to compare floating-point numbers
    //Assert.assertEquals(12.80, p.getPreis());    // nur mit zwei Parameter nicht mehr unterstuetzt
    //der 3. Parameter bedeutet die Genauigkeit, also z.B. 0.00 oder 0.0001


    // Spezialtest gemaess Uebungsaufgabe (PizzaListe)
    @Test
    public void pizzaBestellungUndPreisBerechungSummeTest() {

        PizzaMargherita m = new PizzaMargherita();
        m.setGroesse("gross");

        Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaNapolitana n = new Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaNapolitana();

        PizzaInterface[] pizzaListe = new PizzaInterface[2];
        pizzaListe[0] = m;
        pizzaListe[1] = n;

        Double preisAusPizzaBestellung = 0.00;
        for (PizzaInterface p : pizzaListe) {
            preisAusPizzaBestellung += p.getPreis();
        }

        Assert.assertEquals(42, preisAusPizzaBestellung, 0.00);
    }

}
