package HelloWorld;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rk on 14.10.16.
 */
public class SchiffTest {

    @Test
    public void testHatFahneGehisst() {
        Schiff f = new Schiff();
     // Assert.assertTrue("Fahne muss unbedingt oben sein. Expected=TRUE", f.hatFahneGehisst());
        Assert.assertEquals(true,f.hatFahneGehisst());
    }

}
