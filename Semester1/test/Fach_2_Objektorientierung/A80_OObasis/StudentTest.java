package Fach_2_Objektorientierung.A80_OObasis;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rk on 14.10.16.
 */
public class StudentTest {
    @Test
    public void getGeburtsjahrPerDefaultImmer1970() throws Exception {
        Student s1 = new Student();
        Assert.assertEquals(1970, s1.getGeburtsjahr());
    }

}