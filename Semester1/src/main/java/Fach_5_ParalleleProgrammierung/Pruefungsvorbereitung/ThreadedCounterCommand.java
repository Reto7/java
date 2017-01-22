package Fach_5_ParalleleProgrammierung.Pruefungsvorbereitung;

public class ThreadedCounterCommand extends Thread //implements Runnabl
{
    // CONSTRUCTOR
    // Damit wir als Thread-Benutzer nicht erst die start()-Methode
    // aufrufen müssen, kann ein Thread sich auch selbst starten.
    // Der Konstruktor ruft dazu einfach die eigene start()-Methode auf
    ThreadedCounterCommand() {
        start();
    }

    @Override
    public void run() {
        // Hinweis: Thread.currentThread() ist ressourcenintensiv
        System.out.println("Thread Name:" +Thread.currentThread().getName() +" Prio:"+ Thread.currentThread().getPriority());     // z.  B. main

        // Mittels yield den Thread bezueglich seiner Prioritaet wieder in die
        // Thread-Warteschlange des Systems einordnen
        // Der laufende Thread gibt freiwillig seine Rechenzeit ab
        // Also: Ich setze diese Runde aus und mache weiter, wenn ich das naechste Mal dran bin
        Thread.yield();

        for ( int i = 0; i < 10; i++ )
            System.out.println( i );

        System.out.println( "Das Ende von Thread Name:" +Thread.currentThread().getName() );
    }
}
