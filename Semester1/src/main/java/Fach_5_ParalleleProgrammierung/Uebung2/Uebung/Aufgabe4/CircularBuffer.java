package Fach_5_ParalleleProgrammierung.Uebung2.Uebung.Aufgabe4;

/**
 * Circular buffer.
 * 
 * @author Martin Studer
 *
 */
public class CircularBuffer {
	int[] buffer;

	/**
	 * The capacity of the circular buffer.
	 */
	int capacity;

	/**
	 * The next position to put an element.
	 */
	int insert;

	/**
	 * The next position to get an element.
	 */
	int remove;

	/**
	 * The size of the circular buffer.
	 */
	int size;

	/**
	 * Construct a buffer with given capacity.
	 * @param capacity the buffer capacity
	 */
	CircularBuffer(int capacity) {
		this.buffer = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
		this.insert = 0;
		this.remove = 0;
	}

	/**
	 * Is this buffer empty?
	 * @return true if the buffer is empty, false otherwise
	 */
	boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Is this buffer full?
	 * @return true if the buffer is full, false otherwise
	 */
	boolean isFull() {
		return size == capacity;
	}
	
	/**
	 * Return the size of this buffer.
	 * @return buffer size
	 */
	int size() {
		return size;
	}

	/**
	 * Get buffer element.
	 * @return
	 */
	synchronized int get() {
		while (isEmpty()) {
			try {
				System.out.println("CONSUMER waiting in get");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// producer aufwecken
		if (size == capacity) {
			notify();
		}
		size--;
		int result = buffer[remove];
		remove = (remove + 1) % capacity;
		return result;
	}

	/**
	 * Put buffer element.
	 * @param value
	 */
	synchronized void put(int value) {
		while (isFull()) {
			try {
				System.out.println("PRODUCER waiting in put");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (size == 0) {
			notify();
		}
		size++;
		buffer[insert] = value;
		insert = (insert + 1) % capacity;
	}
}
