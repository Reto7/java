package Fach_6_FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by rk on 22.12.16.
 */
public class KeyBoardReader {

    public static void main(String[] args) throws IOException {

        // java KeyBoardReader P1 P2
        System.out.println("Parameter1: " +args[0]);

        File outputFile = new File("src/Fach_6_FileIO/myDirectory/"+args[0]);
        Writer fileWriter = new FileWriter(outputFile);
        Reader keyboardReader = new InputStreamReader(System.in);

        // by byteverarbeitung wird der char immer auf int gecastet (z.B. 10 = CRLF)
        int c;
        //"(Ende/Speichern mit Ctrl-Z bzw. Strg-D auf Linux!)"
        while( (c=keyboardReader.read()) !=-1 ) {
            System.out.println("Gelesenes Zeichen: " +(char)c);
            fileWriter.write(c);  //muss int entegegenehmen
            //fileWriter.flush();
        }
        System.out.println("File geschrieben: " + outputFile.getAbsolutePath());

        keyboardReader.close();
        fileWriter.close();

    }
}
