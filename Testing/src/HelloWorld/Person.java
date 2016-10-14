package HelloWorld;

/**
 * Created by rk on 13.10.16.
 */
public class Person {

    private String vorname;
    private String nachname;

    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    //*****************************************************************************
    // Automatisch via Generate.... equals and hashcode !!!
    // macht dann keinen Referenzvergleich mehr, sondern vergleicht den INHALT!
    //*****************************************************************************

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (vorname != null ? !vorname.equals(person.vorname) : person.vorname != null) return false;
        return nachname != null ? nachname.equals(person.nachname) : person.nachname == null;
    }

    @Override
    public int hashCode() {
        int result = vorname != null ? vorname.hashCode() : 0;
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        return result;
    }
}
