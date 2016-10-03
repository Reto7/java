package Fach_2_Objektorientierung.A84_Klang_Theorieaufgabe;

/**
 * Created by user on 03.10.2016.
 */
public class Krach extends Klang {
    /* instanzvar */
    private int rauschen, lautstaerke;

    /* klassenvar */
    public static int grundRauschen = 4;

    public Krach(int l, int b, int h) {
        super(b, h);
        lautstaerke = l;
        rauschen = grundRauschen;
    }

    public void mehrPower(int b) {
        baesse += b;
        if (baesse > 10) {
            lautstaerke -= 1;
        }
    }

    public void mehrPower(int l, int b) {
        lautstaerke += l;
        this.mehrPower(b);
    }
}
