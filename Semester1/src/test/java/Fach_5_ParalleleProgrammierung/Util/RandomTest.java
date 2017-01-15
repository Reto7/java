package Fach_5_ParalleleProgrammierung.Util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rk on 14.12.16.
 */
public class RandomTest {
    @Test
    public void randomBetween() throws Exception {
        for (int i = 0; i<100; i++) {
            int r = Random.randomBetween(0,6);
            System.out.println(r);
            Assert.assertTrue(r >= 0 && r <= 6);
        }


    }

}