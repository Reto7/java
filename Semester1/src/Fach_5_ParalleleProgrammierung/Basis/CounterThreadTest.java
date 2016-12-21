package Fach_5_ParalleleProgrammierung.Basis;


/**
 * Created by rk on 08.12.16.
 */
public class CounterThreadTest {

    public static void main(String[] args) {
        //
        CounterThread ct = new CounterThread("counter 1");
        ct.start();
        CounterThread ct2 = new CounterThread("counter 2");
        ct2.start();
    }



}