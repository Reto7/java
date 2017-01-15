package Fach_5_ParalleleProgrammierung.Util;

/**
 * Created by rk on 14.12.16.
 */
public class Random {

    public static int randomBetween(int lower, int upper) {
        return (int) (Math.random() * (upper - lower)) + lower;
    }

}
