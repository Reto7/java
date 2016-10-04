package Fach_2_Objektorientierung.A80_OObasis;

/**
 * Created by rk on 04.10.16.
 */
public class ObjectTest {
    public static void main(String[] args) {
        Student a = new Student();
        System.out.println(a.hashCode());

        Student b = new Student();
        System.out.println(b.hashCode());

        String s1 = "Hallo";
        System.out.println(s1.hashCode());

        String s2 = "Hallo";
        System.out.println(s2.hashCode());

        System.out.println(s1.equals(s2));  // true weil Inhalts-Vergleich
        System.out.println(s1 == s2);       // soll false sein, da Adress-Zeiger Vergleich (eher zufaellig)
    }
}
