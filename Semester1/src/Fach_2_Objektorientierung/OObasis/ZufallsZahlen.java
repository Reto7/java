package Fach_2_Objektorientierung.OObasis;

import java.util.Random;

/**
 * Created by user on 01.10.2016.
 */
public class ZufallsZahlen{
    /*
    Es gibt Fälle, in denen Initialisierungen nicht im Konstruktor und damit für jedes Exemplar erneut,
    sondern genau einmal am Anfang der Benutzung einer Klasse durchgeführt werden müssen
     */

    //Bei einfach zu initialisierenden Klassenattributen erfolgt die Initialisierung bereits bei der Deklaration
    public static final String VERSION = "JBB 1.0";

    //Bei komplexen Klassenattributen verwenden wir einen static Block um diese zu initialisieren
    static {
        ZufallsZahlen.zufallszahlen = new int[ZufallsZahlen.MAX];
        Random rand = new Random(System.currentTimeMillis());
        for(int i = 0; i < ZufallsZahlen.MAX; i++) {
            ZufallsZahlen.zufallszahlen[i] = rand.nextInt(50);
            //System.out.println(i + " : " +ZufallsZahlen.zufallszahlen[i]);
        }
    }

    // Klassenvariablen
    private static final int MAX = 20;
    private static int[] zufallszahlen;

    // Instanzvariablen
    private int irgendEineZahl;

    public int getIrgendEineZahl() {
        return irgendEineZahl;
    }
    public void setIrgendEineZahl(int irgendEineZahl) {
        this.irgendEineZahl = irgendEineZahl;
    }

    @Override
    public String toString() {
        return (irgendEineZahl + " plus " +zufallszahlen[irgendEineZahl]);

    }
}
