package Fach_5_ParalleleProgrammierung.ReaderWriterProblem.Step2;

public class Data {
	Data(int size) {
		values = new int[size];
		noReaders = 0;
		noWriters = 0;
	}
	int[] values;
	int noReaders;
	int noWriters;
}
