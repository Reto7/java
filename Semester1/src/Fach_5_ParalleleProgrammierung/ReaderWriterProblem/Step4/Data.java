package Fach_5_ParalleleProgrammierung.ReaderWriterProblem.Step4;

public class Data {
	Data(int size) {
		values = new int[size];
		noReaders = 0;
		noWriters = 0;
	}

	synchronized void requestRead() throws InterruptedException {
		while (noWriters != 0) {
			wait();
		}
		noReaders++;
	}

	synchronized void releaseRead() {
		noReaders--;
		if (noReaders == 0) {
			notifyAll();
		}
	}

	synchronized void requestWrite() throws InterruptedException {
		while (noReaders != 0 || noWriters != 0) {
			wait();
		}
		noWriters++;
	}

	synchronized void releaseWrite() {
		noWriters--;
		if (noWriters == 0) {
			notifyAll();
		}
	}

	int[] values;
	int noReaders;
	int noWriters;
}
