package Fach_5_ParalleleProgrammierung.ReaderWriterProblem.Step5;

import java.util.Random;

public class Writer extends Thread {
	Data data;
	int sleepTime;
	Writer(Data data, int sleepTime) {
		this.data = data;
		this.sleepTime = sleepTime;
	}
	public void run() {
		Random random = new Random();
		while (true) {
			data.lock.writeLock().lock();
			try {
			for (int j=0; j < data.values.length; j++) {
				data.values[j] = random.nextInt();
			}
			} finally {
				data.lock.writeLock().unlock();
			}
			if (sleepTime >= 0) {
				// wait for a random time between 0 and sleepTime
				try {
					Thread.sleep(random.nextInt(sleepTime));
				} catch (InterruptedException e) {		
				}
			}
		}
	}
}
