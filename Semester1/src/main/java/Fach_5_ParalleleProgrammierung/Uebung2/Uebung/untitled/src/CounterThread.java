public class CounterThread implements Runnable {
    int nr;

    CounterThread(int nr) {
        this.nr = nr;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(nr + ": " + i);
        }
    }
}

