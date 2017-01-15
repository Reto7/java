package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.interfaces.test;

import Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.interfaces.InterfaceBase;

/**
 * Created by rk on 11.10.16.
 */
public class KindInterface1 implements InterfaceBase {

    public void sayHello() {
        System.out.println("Hallo (Kindinterface1)");

    }

    @Override
    public void print() {
        System.out.println("Print (Kindinterface1)");

    }


}
