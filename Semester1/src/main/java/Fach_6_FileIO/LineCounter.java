package Fach_6_FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by RETO KAUFMANN
 */
public class LineCounter {


    public static void main(String[] args) {
        int counter = 0;

        BufferedReader bufferedReader = null;
        try {

            File inputFile = new File("src/pruefungsresultat/songs.txt");
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                counter++;
                System.out.println("Zeile: " + line);
            }
            System.out.println("Zeilen:" + counter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ob OK oder Fehler, auf jeden Fall schliessen
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // WRITE STATS FILE
        FileWriter out = null;
        File staticFile = new File("src/pruefungsresultat/statistic.txt");
        try {
            out = new FileWriter(staticFile);
            out.write(String.valueOf(counter));
            System.out.println("file geschrieben, stats: " +counter );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ob OK oder Fehler, auf jeden Fall schliessen
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
