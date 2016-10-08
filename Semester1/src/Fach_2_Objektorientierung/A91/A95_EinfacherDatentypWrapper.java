package Fach_2_Objektorientierung.A91;

/**
 * Created by rk on 08.10.16.
 */
public class A95_EinfacherDatentypWrapper {
    public static void main(String[] args) {
        //double mit Initcap !
        Double d = new Double(3.14);
        //Wie finden wir heraus, ob die im Objekt gespeicherte
        // Zahl den Wert 0 hat?

        double v = 3.14;

        if (d==v) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (d.doubleValue() == v) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (d.equals(v)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }


}
