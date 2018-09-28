package scanning;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ScanningTest {

    @Test
    public void testElementCleanForDateRecon() {
        Scanning s = new Scanning();
        System.out.println(s.cleanElementForDateRecon("26.07.2018-31"));
        System.out.println(s.cleanElementForDateRecon("26.07.2018"));
    }

}