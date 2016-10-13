package Fach_2_Objektorientierung.Axx_Interfaces.ch.ibw.innerclass;

/**
 * Created by rk on 11.10.16.
 */
public class InnerClassDemo {

    private String name;
    private String vorname;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String toString(){
        PrintData p = new PrintData();
        return p.print();
    }


    // INNERE KLASSE
    // hier kann man auf alles zugreifen was in der AEUSSEREN KLASSE vorhanden ist.
    // Dient dem "Auslagern" von mehrfach verwendeter Funktionalitaet, ohne Instanzierung und ohne Uebergabe von Parametern/Objekten!
    // Aber eine eigene richtige Klasse waere uebersichtlicher bzw. auch besser testbar
    public class PrintData {
        //
        public String print(){
            return vorname + " " +name;
        }
    } //end InnerClassDemo


} //end InnerClassDemo
