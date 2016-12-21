package Fach_5_ParalleleProgrammierung.ReaderWriterProblem.Step3;

public class Data {
	Data(int size) {
		values = new int[size];

		noReaders = 0;
		noWriters = 0;
	}
	int[] values;
	// mehrere Threads, java soll variable nicht cachen! Volatile verhindert das caching, zugriff immer direkt auf speicherplatz!
	volatile int noReaders;
	volatile int noWriters;
}
