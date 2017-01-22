package Fach_5_ParalleleProgrammierung.Pruefungsvorbereitung;

/**
 * Created by user on 21.01.2017.
 */
public class StartThread {
    public static void main(String[] args) throws InterruptedException {
        // falls mittels implements Runnable
        //  Thread t1 = new Thread( new DateCommand() );
        //  t1.start();
        //  Thread t2 = new Thread( new CounterCommand() );
        //  t2.start();

        // falls mit extends Thread
        // Da die Klasse Thread selbst die Schnittstelle Runnable implementiert und
        // die run()-Methode mit leerem Programmcode bereitstellt, können wir auch Thread erweitern
        ThreadedDateCommand dc = new ThreadedDateCommand();
        //dc.start();
        ThreadedCounterCommand cc = new ThreadedCounterCommand();
        //cc.start();

        // ... oder es wuerde auch so funktionieren (kompakt):
        // new DateCommand().start();

        ThreadedInterruptus ti = new ThreadedInterruptus();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // den zuvor gestarteten Thread wieder unterbrechen!
        ti.interrupt();


        // Rendezvous - abwarten bis ALLE fertig sind!
        System.out.println("MAIN: ... warte bis alle fertig sind ! ...........");
        dc.join();
        cc.join();
        ti.join();
        System.out.println("MAIN: ... alle Thread beendet. Fertig, schluss");

    }
}
