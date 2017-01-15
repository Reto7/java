package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeAbstract;

import Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaMargherita;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 16.10.2016.
 */
public class PizzaMargheritaTest {

    // Assertion auf DOUBLE
    //java.lang.AssertionError: Use assertEquals(expected, actual, delta) to compare floating-point numbers
    //Assert.assertEquals(12.80, p.getPreis());    // nur mit zwei Parameter nicht mehr unterstuetzt
    //der 3. Parameter bedeutet die Genauigkeit, also z.B. 0.00 oder 0.0001

    @Test
    public void preisTestKleinePizza(){
        PizzaMargherita p = new PizzaMargherita();
        p.setGroesse("klein");
        Assert.assertEquals(10.00, p.getPreis(), 0.00);
    }

    @Test
    public void preisTestMittlerePizza(){
        PizzaMargherita p = new PizzaMargherita();
        p.setGroesse("mittel");
        Assert.assertEquals(20.00, p.getPreis(), 0.00);
    }

    @Test
    public void preisTestGrossePizza(){
        PizzaMargherita p = new PizzaMargherita();
        p.setGroesse("gross");
        Assert.assertEquals(30.00, p.getPreis(), 0.00);
    }

    @Test
    public void preisTestMitFalscherGroessenAngabeSollFehlerLiefern(){  // bzw. einfach 0.00
        PizzaMargherita p = new PizzaMargherita();
        p.setGroesse("dreieckig");
        Assert.assertEquals(0.00, p.getPreis(), 0.00);
    }

    @Test
    public void preisTestOhneGroessenAngabeSollFehlerLiefern(){  // bzw. einfach 0.00
        PizzaMargherita p = new PizzaMargherita();
        Assert.assertEquals(0.00, p.getPreis(), 0.00);
    }

    @Test
    public void zutatenBasisTestMitAnzahlZutaten(){
        PizzaMargherita p = new PizzaMargherita();
        Assert.assertEquals(3,p.getZutaten().length);

    }
}