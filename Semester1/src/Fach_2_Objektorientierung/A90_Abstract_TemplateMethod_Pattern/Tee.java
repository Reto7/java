package Fach_2_Objektorientierung.A90_Abstract_TemplateMethod_Pattern;

/**
 * Created by user on 23.10.2016.
 */
public class Tee extends KoffeinhaltigesGetraenk {

    public void aufgiessen() {
        System.out.println("lasse den Teebeutel ziehen (aufgiessen)");
    }

    public void zutatenHinzufuegen() {
        System.out.println("fuege Zitrone hinzu (Zutaten)");
    }

}
