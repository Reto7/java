package Fach_5_ParalleleProgrammierung.Uebung2.Uebung.Aufgabe4;

import java.util.Random;

public class Producer extends Thread {
	CircularBuffer data;
	int sleepTime;
	Producer(CircularBuffer data, int sleepTime) {
		this.data = data;
		this.sleepTime = sleepTime;
	}
	public void run() {
	//	try {
			Random random = new Random();
			int value = 0;
			while (true) {

				data.put(value);
				// hier nun wieder alle schlafenden consumer aufwecken
				//System.out.println("Writer feritg, benachrichtige alle wartenden Consumer!");
				//notifyAll();

                value++;



                if (sleepTime >= 0) {
                    // wait for a random time between 0 and sleepTime
                    try {
                        Thread.sleep(random.nextInt(sleepTime));
                    } catch (InterruptedException e) {
                    }
                }
            }
	//	} catch (InterruptedException e) {
	//		e.printStackTrace();
	//	}
	}
}
