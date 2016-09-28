package Fach_1_Java_Grundlagen.A5;
/**
 * Created by user on 11.09.2016.
 */

import Prog1Tools.IOTools;

import java.util.Arrays;


public class A_5_4_ArraySortierer {
    public static void main(String[] args) {

        int count = IOTools.readInt("Wieviele Zahlen möchten Sie eingeben: ");
        int[] zahl = new int[count];
        for (int i=0; i<count; i++) {
            zahl[i] = IOTools.readInt("Bitte " +(i+1) +" Zahl eingeben: ");
        }
        Arrays.sort(zahl);
        for (int x=0; x<zahl.length; x++) {
            System.out.println(zahl[x]);
        }

    }
}
