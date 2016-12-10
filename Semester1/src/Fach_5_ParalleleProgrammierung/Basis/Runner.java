package Fach_5_ParalleleProgrammierung.Basis;

/**
 * Created by rk on 08.12.16.
 * Folgendes Programm erzeugt einen Thread, der abwechselnd 100 ms schläft und
 * 100'000 mal die Methode Thread.yield() aufruft.
 */
class Runner implements Runnable {
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                // das hier gibt den TIMED_WAITING !
                Thread.sleep(100);
                for (int j = 0; j < 100000; j++) {
                    // damit wir ueberhaupt den RUNNABLE Status erhalten
                    // hier macht er also effektiv etwas ...!
                    Thread.yield();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
