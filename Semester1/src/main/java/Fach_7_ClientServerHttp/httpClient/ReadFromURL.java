package Fach_7_ClientServerHttp.httpClient;

import java.net.*;
import java.io.*;

public class ReadFromURL {

    // hier ist rein der GET moeglich, keine HEADERS und so...

    public static void main(String[] args) {
        try {
            URL url = new URL(args[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
