package Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.interfaces.test;

import Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.interfaces.InterfaceBase;

/**
 * Created by rk on 11.10.16.
 */
public class TestInterface {

    // da main sowieso bereits static ist, kann diese hier auch static sein, so müssen wir nicht instanzieren
    public static void printAlleKinder(InterfaceBase[] alleKinder) {
        if (alleKinder != null) {
            for (InterfaceBase kind : alleKinder) {
                kind.print();
            }
        }

    }

    // da main sowieso bereits static ist, kann diese hier auch static sein, so müssen wir nicht instanzieren
    public static void printKind(InterfaceBase kind) {
        if (kind != null) {
            kind.print();
        }
    }

    public static void main(String[] args) {
        KindInterface1 k1 = new KindInterface1();
        KindInterface2 k2 = new KindInterface2();

        InterfaceBase[] kinder = new InterfaceBase[2];
        kinder[0] = k1;


        if (kinder[1] != null) {
            kinder[1].print();
        }

        kinder[1] = k2;


        // da main sowieso bereits static ist, kann diese hier auch static sein, so müssen wir nicht instanzieren
        printAlleKinder(kinder);
        printKind(k1);


        //**************************************
        // ANONYME KLASSE
        //**************************************
        printKind(
                new InterfaceBase() {
                    @Override
                    public void print() {
                        System.out.println("Hallo Anonyme-Klasse");
                    }
                }
        );

    }
}
