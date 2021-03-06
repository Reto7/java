package Fach_5_ParalleleProgrammierung.ReaderWriterProblem.Step5;

import java.util.Random;

public class Reader extends Thread {
	Data data;
	int sleepTime;

	Reader(Data data, int sleepTime) {
		this.data = data;
		this.sleepTime = sleepTime;
	}

	public void run() {
		Random random = new Random();
		while (true) {
			StringBuffer buf = new StringBuffer();
			data.lock.readLock().lock();
			try {
				for (int j = 0; j < data.values.length; j++) {
					buf.append(data.values[j]);
					buf.append(", ");
				}
			} finally {
				data.lock.readLock().unlock();
			}
			System.out.println(buf.toString());
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
