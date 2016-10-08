package Fach_2_Objektorientierung.A90_Vererbung.AbstractTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rk on 08.10.16.
 */
public class TestRahmen {
    public static void main(String[] args) {

        List<Fahrzeug> fahrzeugListe = new ArrayList<Fahrzeug>();

        Auto klapperkiste = new Auto();
        klapperkiste.information();
        klapperkiste.addMitfahrer(new Mitfahrer("Hotzen"));
        klapperkiste.addMitfahrer(new Mitfahrer("Plotz"));
        fahrzeugListe.add(klapperkiste);

        Schiff nemo = new Schiff();
        nemo.information();
        nemo.addMitfahrer(new Mitfahrer("Susi"));
        nemo.addMitfahrer(new Mitfahrer("Strolchi"));
        fahrzeugListe.add(nemo);


        // alle fahrzeuge bewegen
        for (Fahrzeug f : fahrzeugListe){
            System.out.println("........... los gehts ............");
            f.listMitfahrer();
            f.bewegen();

        }
    }
}
