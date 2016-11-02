package Fach_2_Objektorientierung.A11_Michele_Generics.generic2;

/**
 * Created by Michele on 01.11.2016.
 */
public class UtilTest {
    public static void main(String[] args)
    {
        String s = Util.zufall("Essen","Schlafen");
        System.out.println(s);

        Integer i = Util.zufall(123,563);
        System.out.println(i);

        Box<Integer> b1 = new Box<Integer>();
        b1.setValue(452);
        Box<Integer> b2 = new Box<Integer>();
        b2.setValue(481);
        Box<Integer> b = Util.zufall(b1,b2);

        System.out.println(b.getValue());
    }
}
