package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.interfaces.test;

import Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.interfaces.Tier;

/**
 * Created by rk on 11.10.16.
 */
public class Hund implements Tier {

    @Override
    public void lautGeben() {
        System.out.println("wau wau");
    }
}
