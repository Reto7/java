package Fach_5_ParalleleProgrammierung.ReaderWriterProblem.Step4;

public class Data {
	Data(int size) {
		values = new int[size];
		noReaders = 0;
		noWriters = 0;
	}

	// ich haette gerne lesenden Zugriff
	synchronized void requestRead() throws InterruptedException {
		while (noWriters != 0) {
			wait();
		}
		noReaders++;
	}

	synchronized void releaseRead() {
		noReaders--;
		if (noReaders == 0) {
			// alle waiting benachrichtigen/aufwecken
			notifyAll();
		}
	}

	// ich haette gerne schreibenden Zugriff
	synchronized void requestWrite() throws InterruptedException {
		while (noReaders != 0 || noWriters != 0) {
			wait();
		}
		noWriters++;
	}

	synchronized void releaseWrite() {
		noWriters--;
		// pruefung eigentlich nicht notwendig, da es sowieso nur einen writer geben kann.
		// mit noWriters-- geht dieser immer auf 0
		if (noWriters == 0) {
			// alle waiting benachrichtigen/aufwecken
			notifyAll();
		}
	}

	int[] values;
	int noReaders;
	int noWriters;
}
