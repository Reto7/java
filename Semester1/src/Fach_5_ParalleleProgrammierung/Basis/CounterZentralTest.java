package Fach_5_ParalleleProgrammierung.Basis;


/**
 * Created by rk on 08.12.16.
 */
public class CounterZentralTest {

    public static void main(String[] args) {
        Thread t = new Thread(new CounterZentral(),"erster");
        t.start();
        Thread t2 = new Thread(new CounterZentral(),"zweiter");
        t2.start();

    }

}