package Fach_1_Java_Grundlagen.A4;

import Prog1Tools.IOTools;

/**
 * Created by user on 31.08.2016.
 */
public class A_4_11_IOTools_Schaltjahre {
    public static void main(String[] args) {
        String name = IOTools.readString("Wie heissen Sie? ");
        int alter = IOTools.readInt("Wie alt sind Sie? ");
        int tage = alter *365;
        System.out.println("Hallo " +name);
        System.out.println("Sie sind " +tage +" Tage alt");


    }
}


