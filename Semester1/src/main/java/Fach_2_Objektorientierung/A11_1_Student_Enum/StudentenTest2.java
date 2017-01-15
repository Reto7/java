package Fach_2_Objektorientierung.A11_1_Student_Enum;

// ENUM wird static importiert!

import static Fach_2_Objektorientierung.A11_1_Student_Enum.Fach.WIRTSCHAFTLICHESSTUDIUM;

/**
 * Created by rk on 01.11.16.
 */
public class StudentenTest2 {
    public static void main (String[] args) {
        Student Peter = new Student();
        Peter.setName("Peter Honig");
        Peter.setNummer(12345);
        Peter.setFach(WIRTSCHAFTLICHESSTUDIUM);
        System.out.println(Peter);
        System.out.println("Regelstudienzeit fuer sein Studium: " +
                Peter.getFach().regelstudienzeit() + " Semester.");
    }
}