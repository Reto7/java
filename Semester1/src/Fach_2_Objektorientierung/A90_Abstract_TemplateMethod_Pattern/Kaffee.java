package Fach_2_Objektorientierung.A90_Abstract_TemplateMethod_Pattern;

/**
 * Created by user on 23.10.2016.
 */
public class Kaffee extends KoffeinhaltigesGetraenk {

    public void aufgiessen() {
        System.out.println("bruehe Kaffee auf (aufgiessen)");
    }

    public void zutatenHinzufuegen() {
        System.out.println("fuege Zucker und Milch hinzu (Zutaten)");
    }



}
