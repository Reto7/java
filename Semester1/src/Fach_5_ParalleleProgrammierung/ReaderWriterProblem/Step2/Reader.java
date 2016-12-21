package Fach_5_ParalleleProgrammierung.ReaderWriterProblem.Step2;

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
			while (data.noWriters != 0) {
				//nichts tun, also wie warten bis endlich nicht mehr geschrieben wird!
				// NENNT SICH SPIN LOCK! dreht wie verrueckt und benoetigt viel CPU!
			}
			// Problem genau hier!! koennte von einem Writer hier unterbrochen werden!
			data.noReaders++;
			for (int j=0; j < data.values.length; j++) {
				buf.append(data.values[j]);
				buf.append(", ");
			}
			data.noReaders--;
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
