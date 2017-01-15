package Fach_5_ParalleleProgrammierung.CowboyJim;

/**
 * Created by rk on 08.12.16.
 */
public class CowboyJim {

    public static void main(String[] args) {
        // Alle Threads starten
        LaufThread lauf = new LaufThread();
        lauf.start();
        KauThread kau = new KauThread();
        kau.start();

        try {
            // Nach einigen Sekunden die Threads wieder stoppen
            Thread.sleep(5000);

            System.out.println("...start interrupting...");
            lauf.interrupt();
            kau.interrupt();

            // warten bis die Threads effektiv beendet sind (return Anweisung)
            // koennten ja noch beschaeftigt sein mit File schliessen usw.
            lauf.join();
            kau.join();
            System.out.println("...ALLES interrupted UND BEENDET!...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
