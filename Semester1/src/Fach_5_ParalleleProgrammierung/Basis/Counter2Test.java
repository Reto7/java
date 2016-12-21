package Fach_5_ParalleleProgrammierung.Basis;


/**
 * Created by rk on 08.12.16.
 */
public class Counter2Test {

    public static void main(String[] args) {
        Thread t = new Thread(new Counter2(),"erster");
        t.start();
        Thread t2 = new Thread(new Counter2(),"zweiter");
        t2.start();

    }

}