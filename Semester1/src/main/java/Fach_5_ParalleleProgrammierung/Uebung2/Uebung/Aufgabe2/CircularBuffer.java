package Fach_5_ParalleleProgrammierung.Uebung2.Uebung.Aufgabe2;

public class CircularBuffer {
	int[] buffer;
	int capacity;
	int insert;		// next position to put an element
	int remove;		// next position to get an element
	int size;
	CircularBuffer(int capacity) {
		this.buffer = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
		this.insert = 0;
		this.remove = 0;
	}
	boolean isEmpty() {
		return size == 0;
	}
	boolean isFull() {
		return size == capacity;
	}
	int size() {
		return size;
	}
	int get() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		size--;
		int result = buffer[remove];
		remove = (remove + 1) % capacity;
		return result;
	}
	void put(int value) {
		if (isFull()) {
			throw new IllegalStateException();
		}
		size++;
		buffer[insert] = value;
		insert = (insert + 1) % capacity;
	}
}
