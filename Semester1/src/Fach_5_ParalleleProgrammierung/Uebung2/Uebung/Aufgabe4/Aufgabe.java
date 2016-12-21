package Fach_5_ParalleleProgrammierung.Uebung2.Uebung.Aufgabe4;

public class Aufgabe {

	public static void main(String[] args) {
		CircularBuffer buffer = new CircularBuffer(5);
		Producer producer = new Producer(buffer, 80);	// 100: wait 0-99 ms before producing
		Consumer consumer = new Consumer(buffer, 20);	// -1: consume without waiting
		producer.start();
		consumer.start();
	}
}
