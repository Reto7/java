package Fach_6_FileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * TODO, das funktioniert nicht mehr. Weshalb hat's auf dem Notebook zuvor funtioniert, aber nicht auf dem Win PC?
 */
public class FileLocationDynamischAuffinden {

    // vorteil: schneller und man kann zeilenweise mit readLine() vorgehen!
    public void fileHandling() throws Exception {

        // diese struktur soll dynamisch aufgefunden werden, ist relativ zum AKTUELLEN Verzeichnis DIESER KLASSE!
        //String sollLocation = "myDirectory/Wortliste.txt";
        String sollLocation = "WortlisteNEU.txt";
        System.out.println("soll location: " +sollLocation);

        //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(sollLocation);
        //System.out.println(inputStream.toString());

        //InputStream inputStream2 = this.getClass().getClassLoader().getResourceAsStream(sollLocation);
        //InputStream inputStream2 = this.getClass().getResourceAsStream(sollLocation);
        //InputStream inputStream2 = Thread.currentThread().getContextClassLoader().getResourceAsStream(sollLocation);
        //InputStream inputStream2 = FileLocationDynamischAuffinden.class.getClass().getResourceAsStream(sollLocation);
        InputStream inputStream2 = FileLocationDynamischAuffinden.class.getResourceAsStream(sollLocation);
        System.out.println("inputstream2: " +inputStream2);


        //File inputFile = new File("src/Fach_6_FileIO/myDirectory/Wortliste.txt");
        //BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

        if (inputStream2 != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Gelesenes Zeile: " + line);
            }
            bufferedReader.close();
        } else {
            throw new Exception("location not found");
        }
    }

    // Wir sind die eigene "Test Klasse"
    public static void main(String[] args) throws Exception {
            FileLocationDynamischAuffinden x = new FileLocationDynamischAuffinden();
            x.fileHandling();

    }
}
