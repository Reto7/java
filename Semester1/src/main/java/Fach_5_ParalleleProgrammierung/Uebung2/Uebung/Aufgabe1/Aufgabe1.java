package Fach_5_ParalleleProgrammierung.Uebung2.Uebung.Aufgabe1;

import java.util.Vector;

class UpcountThread extends Thread {
	static int count = 0;
	int maxCount, threadNo;
	public UpcountThread(int no, int maxCount) {
		this.threadNo = no;
		this.maxCount = maxCount;
	}
	public void run() {
		while (count < maxCount) {
			System.out.print("Thread " + threadNo + ": " + count);
			count = count + 1;
			System.out.println(" -> " + count);
		}
	}
}
public class Aufgabe1 {
	public static void main(String[] args) {
		final int maxCount = 1000, noThreads = 10;
		Vector<UpcountThread> upcountThreads = new Vector<UpcountThread>();
		for (int i=0; i<noThreads; i++) {
			upcountThreads.add(new UpcountThread(i, maxCount));
		}
		for (int i=0; i<noThreads; i++) {
			upcountThreads.elementAt(i).start();
		}
	}
}