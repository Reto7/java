package LambdaExpressions;

/**
 * Created by user on 01.10.2017.
 */
public class LambdaHello {
//https://javabeginners.de/Klassen_und_Interfaces/Lambda_Ausdruecke.php
    interface Printer {
        void print();
    }

    public static void main(String[] args) {
        Printer p = () -> System.out.println("Hallo Welt!");
        p.print();    // "Hallo Welt!"
    }
}
