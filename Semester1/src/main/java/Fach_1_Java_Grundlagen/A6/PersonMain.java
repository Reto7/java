package Fach_1_Java_Grundlagen.A6;

/**
 * Created by rk on 13.09.16.
 */
public class PersonMain {
    public static void main(String[] args) {

        /*
        Person person1 = new Person();
        person1.firstName = "Hans";
        person1.lastName = "Müller";
        person1.age = 30;
        System.out.println("First-Name: " +person1.firstName);
        */

        Adresse[] adressListe = new Adresse[10];

        Adresse a1 = new Adresse();
        a1.strasse = "Seestrasse";
        a1.hausnummer = 23;
        a1.wohnort = "New York";

        Adresse a2 = new Adresse();
        a2.strasse = "Blumenweg";
        a2.hausnummer = 12;
        a2.wohnort = "London";

        Adresse a3 = new Adresse();
        a3.strasse = "Wolken-Allee";
        a3.hausnummer = 120;
        a3.wohnort = "Paris";

        adressListe[0] = a1;
        adressListe[1] = a2;
        adressListe[2] = a3;


        for (int i=0; i<adressListe.length; i++) {
            System.out.println("Adressliste ["+i+"]: " +adressListe[i]);  //  ==> ergibt kein Nullpointer, da nur Referenzen ausgegeben werden (oder null!)

            if (adressListe[i] != null) {
                System.out.println(adressListe[i].wohnort);
            }
        }

        /*
            Adressliste [0]: Fach_1_Java_Grundlagen.A6.Adresse@1540e19d
             New York
            Adressliste [1]: Fach_1_Java_Grundlagen.A6.Adresse@677327b6
             London
            Adressliste [2]: Fach_1_Java_Grundlagen.A6.Adresse@14ae5a5
             Paris
            Adressliste [3]: null
            Adressliste [4]: null
            Adressliste [5]: null
            Adressliste [6]: null
            Adressliste [7]: null    ==>  System.out.println(adressListe[7].wohnort);  ==> nullPointerException  ... weil "null" kein wohnort hat! (null ist kein objekt!!)
            Adressliste [8]: null
            Adressliste [9]: null
         */

    }

}