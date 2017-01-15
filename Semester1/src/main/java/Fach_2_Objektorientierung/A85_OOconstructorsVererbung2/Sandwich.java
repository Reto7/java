package Fach_2_Objektorientierung.A85_OOconstructorsVererbung2;

/**
 * Created by user on 07.11.2016.
 */



import java.util.*;



public class Sandwich extends PortableLunch {

    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    // constructor
    public Sandwich() {
        System.out.println("Sandwich()");
    }

    /**
     The constructor:

     public Sandwich() {
     System.out.println("Sandwich()");
     }
     Is translated by the compiler to:

     public Sandwich() {
     super();   // Compiler adds it if it is not explicitly added by programmer
     // All the instance variable initialization is moved here by the compiler.
     b = new Bread();
     c = new Cheese();
     l = new Lettuce();

     System.out.println("Sandwich()");
     }

     */


    public static void main(String[] args) {
        new Sandwich();

    }
}

class Meal {
    Meal() { System.out.println("Meal()"); }
}

class Bread {
    Bread() { System.out.println("Bread()"); }
}

class Cheese {
    Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
    Lettuce() { System.out.println("Lettuce()"); }
}

class Lunch extends Meal {
    Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
    PortableLunch() { System.out.println("PortableLunch()");}
}
