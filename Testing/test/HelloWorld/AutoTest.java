package HelloWorld;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rk on 14.10.16.
 */
public class AutoTest {

    @Test
    public void testFarbe(){
        Auto a = new Auto();
        Assert.assertEquals("blau", a.getFarbe());
    }
}
