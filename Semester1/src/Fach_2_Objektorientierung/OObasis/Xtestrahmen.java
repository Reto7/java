package Fach_2_Objektorientierung.OObasis;

/**
 * Created by user on 01.10.2016.
 */
public class Xtestrahmen {
    public static void main(String[] args) {
        Xauto vw = new Xauto();
        // eigene auto var.
        vw.autoVariableProtected = "X";
        vw.autoVariablePublic = "X";
        // hat auto vom fahrzeug vererbt bekommen.
        vw.fahrzeugVariableProtected = "von vererbung bekommen";
        vw.fahrzeugVariablePublic = "von vererbung bekommen";

        /*
        protected-Eigenschaften werden an alle Unterklassen vererbt.
        Klassen, die sich im gleichen Paket befinden, können alle protected-Eigenschaften sehen,
        denn protected ist eine Erweiterung der Paketsichtbarkeit.
         */


    }
}
