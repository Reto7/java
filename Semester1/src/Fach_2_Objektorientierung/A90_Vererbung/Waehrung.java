package Fach_2_Objektorientierung.A90_Vererbung;

/**
 * -----------------------------------------------------------------------------------------------------
 * Created by rk on 04.10.16.
 */

/** Diese Klasse symbolisiert eine beliebige Waehrung */
public abstract class Waehrung {

    /** Gibt den Wert des Objekts in US-Dollar zurueck */
    public abstract double dollarBetrag();

    /** Gibt den Wert der Waehrung in Dollar als String zurueck */
    public String toString() {
        return "$"+dollarBetrag();
    }

    /** Prueft, ob das Objekt gleich dem Parameter-Objekt obj ist */
    public boolean equals(Object obj) {
        if (obj == null)                 // Vergleich mit null-Referenz
            return false;
        if (obj == this )                // Vergleich mit sich selber
            return true;
        if (!obj.getClass().equals(getClass()))   // Datentyp-Vergleich
            return false;

        Waehrung that = (Waehrung) obj;        // Typecast und Inhalts-
        return this.dollarBetrag() == that.dollarBetrag(); // Vergleich
    }

    /** Liefert den Hashcode eines Objekts */
    public int hashCode() {
        return (int)(dollarBetrag()*100);
    }

}