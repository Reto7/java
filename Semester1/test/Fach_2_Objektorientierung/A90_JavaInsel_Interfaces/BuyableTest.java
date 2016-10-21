package Fach_2_Objektorientierung.A90_JavaInsel_Interfaces;

import org.junit.Assert;
import org.junit.Test;

/**
 * Mit Magazine und Chocolate haben wir zwei Klassen, die Buyable implementieren.
 * Damit existieren zwei Klassen, die einen gemeinsamen Typ und beide eine gemeinsame
 * Methode price() besitzen.
 */
public class BuyableTest {

    @Test
    public void testBuyable() {
        Buyable b1 = new Magazine();
        Buyable b2 = new Chocolate();
        System.out.println(b1.price());
        System.out.println(b2.price());
    }

    @Test
    public void testBuyableCalculateSum() {
        // Ein Magazin ist auch Buyable
        Magazine madMag = new Magazine();
        madMag.price = 2.50;
        // direkt ein Buyable
        Buyable2 toblerone = new Chocolate();   // Ohne den Preis zu setzen kostet es 0.69
        // Noch ein Magazin das Buyable ist
        Magazine maxim = new Magazine();
        maxim.price = 3.00;
        // summieren!
        double summe = Buyable2.calculateSum(new Buyable2[]{madMag, maxim, toblerone});
        Assert.assertEquals(6.19, round(summe,2), 0.00);
    }

    // Hilfsmethode, gehoert natuerlich nicht hierher
    private double round(double zahl, int stellen) {
        return (double) ((int)zahl + (Math.round(Math.pow(10,stellen)*(zahl-(int)zahl)))/(Math.pow(10,stellen)));
    }
}
