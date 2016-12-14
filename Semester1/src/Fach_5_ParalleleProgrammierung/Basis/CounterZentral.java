package Fach_5_ParalleleProgrammierung.Basis;

import Fach_5_ParalleleProgrammierung.Util.Random;

/**
 * Siehe TEST-Klasse CounterTest!
 */
public class CounterZentral implements Runnable{

    private int iZentral = 0;
    String lock = "lock";

    // das in der run() Methode kann parallel ablaufen
    @Override
    public void run() {
        //*******************************
        //3x kritischer Bereich!!
        //*******************************
//        // 1.KRITISCHER BEREICH: Pruefung des zentralen Zaehlers
//        while( iZentral <= 20)
//        {
//            // 2.KRITISCHER BEREICH: Erhoehung des zentralen ZAEHLERS
//            iZentral++ ;
//            // 3. KRITTISCHER BEREICH: Ausgabe des zentrlen Zaehlers
//            System.out.println(Thread.currentThread()  +", zentraler-Zaehler: " +iZentral);
//            try {
//                // bis 2 Sekunde warten
//                Thread.sleep(Random.randomBetween(1,2000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        //*******************************
        //Wir ändern jetzt den Code so ab, daß die Prüfung und die Inkrementierung und die Ausgabe nur zusammen
        //ausgeführt werden können.
        //*******************************
        boolean bContinue = true;
        while ( bContinue ) {
            try {
                // bis 2 Sekunde warten
                Thread.sleep(Random.randomBetween(1, 2000));
            } catch (InterruptedException e) {

            }
            // KRITISCHER BEREICH zusammen, sychronisiert
            bContinue = increment();

            //System.out.println(Thread.currentThread() + ", zentraler-Zaehler: " + getIzaehler());

        }
    }

    private synchronized boolean increment() {
        System.out.println(Thread.currentThread() + ", zentraler-Zaehler: " + getIzaehler());
        if (iZentral < 20) {
            iZentral++;
            return true;
        } else {
            return false;
        }
    }

    public synchronized long getIzaehler()
    {
        return iZentral;
    }

}

