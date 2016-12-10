package Fach_5_ParalleleProgrammierung.Basis;


/**
 * Created by rk on 08.12.16.
 */
public class CounterThreadTest {

    public static void main(String[] args) {
        //
        CounterThread ct = new CounterThread();
        ct.start();
        CounterThread ct2 = new CounterThread();
        ct2.start();
    }



}