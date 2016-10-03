package Fach_2_Objektorientierung.A85_OOconstructorsVererbung;

/**
 * Created by rk on 27.09.16.
 */
class Hund extends Fuchs {

    Hund() {
        System.out.println("Hund"); //TODO weshalb kommt der am Schluss?
    }

    // Instanzvariablen???  //TODO weshalb kommen die vor dem Constructor
    // Variablen muessen zuerst vorhanden sein, koennen ja im Constructor
    // bereits beschrieben werden.
    Maus m = new Maus(); //Maus
    Ratte r = new Ratte(); //Maus,Ratte


    //git test
}
