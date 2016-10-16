package Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeAbstract;

import Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaNapolitana;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 16.10.2016.
 */
public class PizzaNapolitanaTest {

    @Test
    public void preisTest(){
        Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaNapolitana p = new Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaNapolitana();
        //java.lang.AssertionError: Use assertEquals(expected, actual, delta) to compare floating-point numbers
        //Assert.assertEquals(12.80, p.getPreis());    // nur mit zwei Parameter nicht mehr unterstuetzt
        //der 3. Parameter bedeutet die Genauigkeit, also z.B. 0.00 oder 0.0001
        Assert.assertEquals(12.00, p.getPreis(), 0.00);
    }

    @Test
    public void zutatenBasisTestMitAnzahlZutaten(){
        Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface.PizzaNapolitana p = new PizzaNapolitana();
        Assert.assertEquals(4,p.getZutaten().length);
    }

}