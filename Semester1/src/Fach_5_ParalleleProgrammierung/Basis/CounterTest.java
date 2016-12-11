package Fach_5_ParalleleProgrammierung.Basis;


/**
 * Created by rk on 08.12.16.
 */
public class CounterTest {

    public static void main(String[] args) {
        Thread t = new Thread(new Counter("counter1"));
        t.start();
        Thread t2 = new Thread(new Counter("counter2"));
        t2.start();
    }

}