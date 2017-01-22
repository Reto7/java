package Fach_5_ParalleleProgrammierung.Pruefungsvorbereitung;

public class ThreadedInterruptus extends Thread{

    // CONSTRUCTOR
    // Damit wir als Thread-Benutzer nicht erst die start()-Methode
    // aufrufen müssen, kann ein Thread sich auch selbst starten.
    // Der Konstruktor ruft dazu einfach die eigene start()-Methode auf
    ThreadedInterruptus() {
        start();
    }

    @Override
    public void run() {
        // Hinweis: Thread.currentThread() ist ressourcenintensiv
        System.out.println("Thread Name:" +Thread.currentThread().getName() +" Prio:"+ Thread.currentThread().getPriority());     // z.  B. main

        // Die Objektmethode interrupt() setzt in einem (anderen) Thread-Objekt ein Flag, dass es
        // einen Antrag gab, den Thread zu beenden. Sie beendet aber den Thread nicht, obwohl es der
        // Methodenname nahelegt.
        while ( ! isInterrupted() )
        {
            System.out.println( "Und er läuft und er läuft und er läuft" );
            try {
                Thread.sleep( 500 );
            }
            catch ( InterruptedException e ){
                // Die run()-Methode im Thread ist so implementiert, dass die Schleife genau dann verlassen wird,
                // wenn isInterrupted() den Wert true ergibt, also von außen die interrupt()-Methode für dieses
                // Thread-Exemplar aufgerufen wurde.
                // Hier nun das Abbruch-Flag neu setzen, damit isInterrupted() das Ende bestimmen kann
                interrupt();
                System.out.println( "Unterbrechung in sleep()" );
            }
        }
        System.out.println( "Das Ende von Thread Name:" +Thread.currentThread().getName() );

    };

}
