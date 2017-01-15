package Fach_2_Objektorientierung.A80_OObasis;

/**
 * Created by rk on 20.09.16.
 */
public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student("Gitty",11333,Student.GERMANISTIKSTUDIUM,1980, Student.WEIBLICH);
        //s1.setName("Hans");
        //s1.setNummer(11113);

        System.out.println(s1); /* aenderung */
    }
}
