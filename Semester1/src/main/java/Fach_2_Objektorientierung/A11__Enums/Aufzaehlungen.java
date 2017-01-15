package Fach_2_Objektorientierung.A11__Enums;

// ENUM wird static importiert!
import static Fach_2_Objektorientierung.A11__Enums.Jahreszeit.*;

public class Aufzaehlungen {
    public static void main(String[] args) {
        Jahreszeit x = HERBST;
        System.out.println(x);

        for (Jahreszeit jz : Jahreszeit.values())
            System.out.println(jz + " hat den Wert " + jz.ordinal());

    }
}
