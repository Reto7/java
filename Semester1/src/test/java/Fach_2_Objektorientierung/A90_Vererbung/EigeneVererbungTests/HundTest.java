package Fach_2_Objektorientierung.A90_Vererbung.EigeneVererbungTests;

import org.junit.Test;

/**
 * Created by user on 20.10.2016.
 */
public class HundTest {

    @Test
    public void testeDenHund() {
        Hund bello = new Hund();
        bello.setName("Bello");
        bello.bellen();

        Hund susi = new Hund();
        susi.setName("Susi");
        susi.bellen();

        // Hund ist ja auch ein Object
        Object[] objektListe = {bello,susi};

        // Muss nun wieder in Hund zurueckgecastet werden
        for (Object h : objektListe) {
            if (h instanceof Hund) {
                Hund x = (Hund) h;
                x.bellen();
                System.out.println(x.getClass().getName());
            }
        }



    }

}