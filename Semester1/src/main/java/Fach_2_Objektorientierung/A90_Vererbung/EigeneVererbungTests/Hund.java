package Fach_2_Objektorientierung.A90_Vererbung.EigeneVererbungTests;

/**
 * Created by user on 20.10.2016.
 * siehe Testklasse H:\DATEN\Intellij-Workspace\Semester1\test\Fach_2_Objektorientierung\A90_Vererbung\EigeneVererbungTests\HundTest.java
 */
public class Hund {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void bellen(){
        System.out.println("wau wau, ich bin " +this.name);
    }
}
