package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.PizzaUebungsaufgabeInterface;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 16.10.2016.
 */
public class PizzaNapolitanaTest {

    @Test
    public void preisTest(){
        PizzaNapolitana p = new PizzaNapolitana();
        //java.lang.AssertionError: Use assertEquals(expected, actual, delta) to compare floating-point numbers
        //Assert.assertEquals(12.80, p.getPreis());    // nur mit zwei Parameter nicht mehr unterstuetzt
        //der 3. Parameter bedeutet die Genauigkeit, also z.B. 0.00 oder 0.0001
        Assert.assertEquals(12.00, p.getPreis(), 0.00);
    }

    @Test
    public void zutatenBasisTestMitAnzahlZutaten(){
        PizzaNapolitana p = new PizzaNapolitana();
        Assert.assertEquals(4,p.getZutaten().length);
    }

}