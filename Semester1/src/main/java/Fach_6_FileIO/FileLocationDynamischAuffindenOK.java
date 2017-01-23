package Fach_6_FileIO;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;

/**
 * Created by rk on 22.12.16.
 */
public class FileLocationDynamischAuffindenOK {

    // vorteil: schneller und man kann zeilenweise mit readLine() vorgehen!

    public static void main(String[] args) throws IOException {

        // diese struktur soll dynamisch aufgefunden werden, ist relativ zum AKTUELLEN Verzeichnis DIESER KLASSE!
        //String sollLocation = "myDirectory/Wortliste.txt";
        String sollLocation = "Wortliste.txt";

        //InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(sollLocation);
        //System.out.println(inputStream.toString());

        InputStream inputStream2 = FileLocationDynamischAuffindenOK.class.getResourceAsStream(sollLocation);
        System.out.println(inputStream2);


        //File inputFile = new File("src/Fach_6_FileIO/myDirectory/Wortliste.txt");
        //BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("Gelesenes Zeile: " +line);
        }
        bufferedReader.close();


    }
}
