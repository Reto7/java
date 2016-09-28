package Fach_1_Java_Grundlagen.A5;

/**
 * eine TABELLE
 */
public class MehrdimensionaleArrays {
    public static void main(String[] args) {
        // 31 tage, 24 h
        String[][] termine = new String[31][24];
        // initialize all entries with the empty string
        for (int tagListe = 0; tagListe<termine.length; tagListe++) {
            for (int stundenListe = 0; stundenListe<termine[tagListe].length; stundenListe++){
                termine[tagListe][stundenListe] = "-";
            }
        }




    }
}
