package Fach_2_Objektorientierung.A90_Vererbung.AbstractTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Nicht immer soll eine Klasse sofort ausprogrammiert werden.
 * Zum Beispiel dann nicht, wenn die Oberklasse lediglich Methoden
 * für die Unterklassen vorgeben möchte, aber nicht weiß, wie sie
 * diese implementieren soll. In Java gibt es dazu zwei
 * Konzepte: abstrakte Klassen und Interfaces
 */
public abstract class Fahrzeug {

    // Instanzvariablen
    private List<Mitfahrer> mitfahrer;


    //getter/setter
    public List<Mitfahrer> getMitfahrer() {
        return mitfahrer;
    }

    //public void setMitfahrer(List<Mitfahrer> mitfahrer) {
    //    this.mitfahrer = mitfahrer;
    //}

    public void addMitfahrer(Mitfahrer neuerMitfahrer) {
        // neue mitfahrerliste instanzieren
        if (this.mitfahrer == null) {
            this.mitfahrer = new ArrayList<Mitfahrer>();
        }
        this.mitfahrer.add(neuerMitfahrer);
    }

    public void listMitfahrer() {
        for (Mitfahrer m : getMitfahrer()){
            System.out.println(m.name);
        }
    }

    // Methoden
    public abstract void bewegen();

    public String information() {
        String info = "ich bin ein Fahrzeug vom Typ " +this.getClass().getSimpleName();
        System.out.println(info);
        return info;
    }


}
