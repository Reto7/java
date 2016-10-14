package HelloWorld;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *   CTRL-Shift-T , dann JUNIT4 auswaehlen
 */
public class HelloWorldTest {

    @Test
    public void test(){
        HelloWorld w = new HelloWorld();
        String bla = w.sayHello();

        Assert.assertEquals("EXPECTED value hallo","hallo",bla);
    }

}