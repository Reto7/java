package HelloWorld;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rk on 13.10.16.
 */
public class PersonTest {

    @Test
    public void testEquals() {

        Person p1 = new Person();
        p1.setVorname("Peter");
        p1.setNachname("Müller");

        Person p2 = new Person();
        p2.setVorname("Peter");
        p2.setNachname("Müller");

        //assertTrue gibt keine gute Fehlermeldung zurueck
        //Assert.assertTrue("EXPECTED p1 is equal to p2", p1.equals(p2));

        //assertEquals gibt schoen zurueck was expected ist
        Assert.assertEquals(p1,p2);

    }

}