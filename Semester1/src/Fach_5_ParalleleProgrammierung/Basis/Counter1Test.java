package Fach_5_ParalleleProgrammierung.Basis;


/**
 * Created by rk on 08.12.16.
 */
public class Counter1Test{

    public static void main(String[] args) {
        Thread t = new Thread(new Counter1("counter1"));
        t.start();
        Thread t2 = new Thread(new Counter1("counter2"));
        t2.start();
    }

}