package Fach_5_ParalleleProgrammierung.CowboyJim;

/**
 * Created by rk on 08.12.16.
 */
public class KauThread extends Thread{

    // das in der run() Methode kann parallel ablaufen
    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println("schmatz");
            try {
                // 1 Sekunde warten
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                // We've been interrupted: no more messages.
                System.out.println("KauThread  ... interrupded");
                return;
            }

        }
    }
}
