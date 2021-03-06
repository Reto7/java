package Fach_6_FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by rk on 22.12.16.
 */
public class DistinctWords {

    // vorteil: schneller und man kann zeilenweise mit readLine() vorgehen!

    public static void main(String[] args) throws IOException {


        File inputFile = new File("src/main/java/Fach_6_FileIO/myDirectory/Wortliste.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

        HashSet<String> hashSet = new HashSet<String>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("Gelesenes Zeile: " +line);

            // 1. Split the words
            String[] lineWordList = line.split(" ");

            // 2. fill the hashset
            for (String wort : lineWordList) {
                // die ADD Methode der HashSet Klasse macht den ADD nur
                // wenn dasselbe Objekt nicht schon drin ist (ist wie eine Collection)
                // dazu wird die equals() Methode des Objekts verwendet!
                hashSet.add(wort);
            }

        }
        bufferedReader.close();

        // 3. write distinct words in new file
        FileWriter out = new FileWriter("src/main/java/Fach_6_FileIO/myDirectory/songs-words-distinct.txt");
        for (String w : hashSet) {
            System.out.println("Distinct word: "+w);
            out.write(w+"\n") ;
        }
        out.close();

    }
}
