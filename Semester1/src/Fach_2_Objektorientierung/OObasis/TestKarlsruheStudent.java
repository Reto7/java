package Fach_2_Objektorientierung.OObasis;

/**
 * Created by rk on 20.09.16.
 */
public class TestKarlsruheStudent {
    public static void main(String[] args) {
        Student s1 = new KarlsruherStudent();
        s1.setName("Hans");
        s1.setNummer(11113);
        s1.setFach(Student.GERMANISTIKSTUDIUM);

        System.out.println(s1); /* aenderung */
    }
}
