package Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.abstractbase.test;

import Fach_2_Objektorientierung.A90_Interfaces.ch.ibw.abstractbase.AbstractBase;

/**
 * Created by Michele on 11.10.2016.
 */
public class TestAbstract {

    public static void main(String[] args)
    {
        KindKlasse1 kind1 = new KindKlasse1();
        KindKlasse2 kind2 = new KindKlasse2();
        KindKlasse3 kind3 = new KindKlasse3();
        KindKlasse4 kind4 = new KindKlasse4();

        kind1.print();
        kind2.print();
        kind3.print();
        kind4.print();

        System.out.println();

        AbstractBase[] arrayBase = new AbstractBase[4];
        arrayBase[0] = kind1;
        arrayBase[1] = kind2;
        arrayBase[2] = kind3;
        arrayBase[3] = kind4;

        for (AbstractBase base : arrayBase){
            base.print();
            base.sayHallo();
        }

    }
}
