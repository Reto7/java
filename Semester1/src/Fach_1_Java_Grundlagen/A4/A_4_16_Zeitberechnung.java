package Fach_1_Java_Grundlagen.A4; /**
 * Created by user on 02.09.2016.
 */

import Prog1Tools.IOTools;

public class A_4_16_Zeitberechnung {
    public static void main(String[] args) {

        int sek = IOTools.readInteger( "Sekunden: " );
        //int sek = 158036522;
        System.out.println("CHECK Ausgangswert : " + sek);

        // alle gewünschten outputwerte auch in sekunden umrechnen
        int jahrInSek = 365 * 24 * 60 * 60;
        int tagInSek =        24 * 60 * 60;
        int stuInSek =             60 * 60;
        int minInSek =                  60;
        System.out.println("CHECK jahrInSek    : " + jahrInSek);

        int jahre = (int) (sek / jahrInSek);
        double jahreR = sek % jahrInSek;   // rest
        System.out.print("Jahre : " + jahre);
        System.out.println("  JahreR : " + jahreR);  // rest

        int tage = (int) (jahreR / tagInSek);
        double tageR = jahreR % tagInSek;
        System.out.print("Tage : " + tage);
        System.out.println("  TageR : " + tageR);

        int stu = (int) (tageR / stuInSek);
        double stuR = tageR % stuInSek;
        System.out.print("Stu : " + stu);
        System.out.println("  StuR : " + stuR);

        int min = (int) (stuR / minInSek);
        double minR = stuR % minInSek;
        System.out.print("Min : " + min);
        System.out.println("  MinR : " + minR);

        int sekunden = (int) minR;
        System.out.println("Sek : " + sekunden);
    }
}
