package Fach_5_ParalleleProgrammierung.Pruefungsvorbereitung;

public class ThreadedDateCommand extends Thread //implements Runnable
{
    // CONSTRUCTOR
    // Damit wir als Thread-Benutzer nicht erst die start()-Methode
    // aufrufen müssen, kann ein Thread sich auch selbst starten.
    // Der Konstruktor ruft dazu einfach die eigene start()-Methode auf
    ThreadedDateCommand() {
        start();
    }

    @Override
    public void run() {
        // Hinweis: Thread.currentThread() ist ressourcenintensiv
        System.out.println("Thread Name:" +Thread.currentThread().getName() +" Prio:"+ Thread.currentThread().getPriority());     // z.  B. main

        try {
            // Warten und nach Ablauf der genannten Millisekunden zum Thread zureckkehren
            Thread.sleep( 2000 );
            System.out.println( "Zeit ist um." );
        } catch ( InterruptedException e ) { e.printStackTrace(); }

        // Hinweis: Thread.currentThread() ist ressourcenintensiv
        System.out.println("Thread Name:" +Thread.currentThread().getName() +" Prio:"+ Thread.currentThread().getPriority());     // z.  B. main

        for ( int i = 0; i < 10; i++ )
            System.out.println( new java.util.Date() );

        System.out.println( "Das Ende von Thread Name:" +Thread.currentThread().getName() );
    }
}
