package Fach_1_Java_Grundlagen.A4;
/**
 * Created by user on 03.09.2016.
 */
import Prog1Tools.IOTools;

public class A_4_31_Zahlenraten_Hausaufgabe {

    public static void main(String[] args) {
        System.out.println("Hallo Mitspieler");

        int rateversuch = 0;
        int eingabe = 0;
        int geheimZahl = (int) (99 * Math.random() + 1);
        //System.out.println(geheimZahl);
        do {
            rateversuch++;
            eingabe = IOTools.readInt("Versuch " +rateversuch +": Bitte raten Sie eine Zahl (1-100): ");
            if (geheimZahl > eingabe){
                System.out.println("Meine Zahl ist grösser!");
            } else if (geheimZahl < eingabe){
                System.out.println("Meine Zahl ist kleiner!");
            } else {
                System.out.println("Ja richtig! Meine Zahl ist auch " + geheimZahl);
            }
        } while (eingabe != geheimZahl);

    }
}
