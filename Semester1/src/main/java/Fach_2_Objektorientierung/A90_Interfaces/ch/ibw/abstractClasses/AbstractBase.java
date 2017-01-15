package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.abstractClasses;

import Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.interfaces.InterfaceBase;

/**
 * Created by rk on 11.10.16.
 */
public abstract class AbstractBase implements InterfaceBase {

    public void sayHello(){
    };

    public abstract void print();  // ohne body weil mit keyword abstract. wird hier ja nicht implementiert, sondern nur vorgegeben

}
