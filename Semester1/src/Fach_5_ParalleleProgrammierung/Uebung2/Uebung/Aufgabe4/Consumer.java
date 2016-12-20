package Fach_5_ParalleleProgrammierung.Uebung2.Uebung.Aufgabe4;

import java.util.Random;

public class Consumer extends Thread {
	CircularBuffer buffer;

	int sleepTime;

	Consumer(CircularBuffer data, int sleepTime) {
		this.buffer = data;
		this.sleepTime = sleepTime;
	}

	public void run() {

	//	try {
			Random random = new Random();
			while (true) {


				int value = buffer.get();
				System.out.println(value);

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
