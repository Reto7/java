package Fach_5_ParalleleProgrammierung.Basis;

/**
 * Created by rk on 08.12.16.
 */
public class RunnerTest {
    public static void main(String[] args) throws InterruptedException {
        Runner c = new Runner();
        Thread r = new Thread(c);
        System.out.println("1 : " +r.getState()); // 1  running
        r.start();

        while (r.isAlive()) {
            System.out.println("2 : " +r.getState()); // 2   waiting
            Thread.sleep(100);
        }
        System.out.println("3 : " +r.getState()); // 3  dead
    }
}