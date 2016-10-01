package Fach_2_Objektorientierung.OObasis;

/**
 * Created by user on 01.10.2016.
 */
public class ZufallsZahlenTestStatischerInitialisator {
    public static void main(String[] args) {
        ZufallsZahlen x = new ZufallsZahlen();
        x.setIrgendEineZahl(5);
        System.out.println(x);

        ZufallsZahlen y = new ZufallsZahlen();
        y.setIrgendEineZahl(5);
        System.out.println(y);
    }
}
