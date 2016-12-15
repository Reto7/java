import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {
	Data(int size) {
		values = new int[size];
		lock = new ReentrantReadWriteLock();
	}

	int[] values;
	ReentrantReadWriteLock lock;
}
