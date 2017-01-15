package Fach_2_Objektorientierung.A80_OObasis;

/**
 * Created by user on 01.10.2016.
 */
public class Xfahrzeug {
    private String fahrzeugVariablePrivat = "Hallo";
    protected String  fahrzeugVariableProtected = "Hallo";
    public String  fahrzeugVariablePublic = "Hallo";

        /*
        protected-Eigenschaften werden an alle Unterklassen vererbt.
        Klassen, die sich im gleichen Paket befinden, können alle protected-Eigenschaften sehen,
        denn protected ist eine Erweiterung der Paketsichtbarkeit.

        --> Auf PROTECTED Elemente kann nur von Klassen aus zugegriffen werden,
            welche sich im gleichen Paket befinden
            oder welche eine Kindklasse einer solchen Klasse sind.
         */

}
