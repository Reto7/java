package Fach_7_ClientServerHttp.DateTimeServerReto.serialized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateTimeProtokoll {
    static SimpleDateFormat   // Formate fuer den Zeitpunkt
            time = new SimpleDateFormat("'Es ist gerade 'H'.'mm' Uhr.'"),
            date = new SimpleDateFormat("'Heute ist 'EEEE', der 'dd.MM.yy");

    Socket s;                   // Socket in Verbindung mit dem Client
    BufferedReader vomClient;   // Eingabe-Strom vom Client
    //PrintWriter zumClient;      // Ausgabe-Strom zum Client
    ObjectOutputStream zumClient;

    public DateTimeProtokoll(Socket s) {  // Konstruktor
        try {
            this.s = s;
            vomClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //zumClient = new PrintWriter(s.getOutputStream(),true);
            zumClient = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException e) {
            System.out.println("IO-Error");
            e.printStackTrace();
        }
    }
    public void transact() {     // Methode, die das Protokoll abwickelt
        System.out.println("Protokoll gestartet");
        try {
            //zumClient.println("Geben Sie DATE oder TIME ein");
            String wunsch = vomClient.readLine();   // v. Client empfangen
            Date jetzt = new Date();                // Zeitpunkt bestimmen
            // vom Client empfangenes Kommando ausfuehren
            if (wunsch.equalsIgnoreCase("date")) {
                //zumClient.println(date.format(jetzt));
                DateTimeTO dateTimeTO = new DateTimeTO();
                dateTimeTO.setDate(date.format(jetzt));
                System.out.println("DateTimeTO erstellt mit DATE");
                XmlSerializer x = new XmlSerializer();
                String serialized = x.serialize(dateTimeTO);
                // senden!
//                OutputStream out = null;
//                try {
//                    out.write(serialized.getBytes());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                zumClient.writeObject(serialized);
                //BufferedOutputStream bos = new BufferedOutputStream(out);
                //ObjectOutputStream oos = new ObjectOutputStream(bos);
                //oos.writeObject(oos);
                zumClient.close();
            }
            else if (wunsch.equalsIgnoreCase("time")) {
                //zumClient.println(time.format(jetzt));
                DateTimeTO dateTimeTO = new DateTimeTO();
                dateTimeTO.setTime(time.format(jetzt));
                System.out.println("DateTimeTO erstellt mit TIME");
                XmlSerializer x = new XmlSerializer();
                x.serialize(dateTimeTO);
            }
//            else
//                zumClient.println(wunsch +" ist als Kommando unzulaessig!");






            s.close(); // Socket (und damit auch Stroeme) schliessen

        } catch (IOException e) {
            System.out.println("IO-Error");
        }
        System.out.println("Protokoll beendet");
    }
}