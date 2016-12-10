package Fach_5_ParalleleProgrammierung.CowboyJim;

/**
 * Created by rk on 08.12.16.
 */
public class LaufThread extends Thread {

    // das in der run() Methode kann parallel ablaufen
    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println("links");
            try {
                // 1 Sekunde warten
                Thread.sleep(300);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                // We've been interrupted: no more messages.
                System.out.println("LaufThread links ... interrupded");
                return;
            }
            System.out.println("rechts");
            try {
                // 1 Sekunde warten
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                // We've been interrupted: no more messages.
                System.out.println("LaufThread rechts ... interrupded");
                return;
            }
        }
    }
}
