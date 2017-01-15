package Fach_2_Objektorientierung.A90_Abstract_TemplateMethod_Pattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 23.10.2016.
 */
public class KoffeinhaltigesGetraenkTest {
    @Test
    public void zubereitungsRezept() throws Exception {

        Kaffee espresso = new Kaffee();
        espresso.zubereitungsRezept();

        Tee lemonGrass = new Tee();
        lemonGrass.zubereitungsRezept();
    }

}