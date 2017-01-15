package Fach_7_ClientServerHttp.DateTimeClientReto.serialized;

import java.net.*;
import java.io.*;

class DateTimeClientSerialized {
    public static void main(String[] args) throws ClassNotFoundException {
        String hostName = "";   // Rechner-Name bzw. -Adresse
        int port;               // Port-Nummer
        Socket c;               // Socket fuer die Verbindung zum Server

        try {
            hostName = args[0];
            port = Integer.parseInt(args[1]);
            c = new Socket(hostName, port);



            PrintWriter zumServer = new PrintWriter(c.getOutputStream(),true);

            //BufferedReader vonTastatur = new BufferedReader(new InputStreamReader(System.in));

            // Protokoll abwickeln
            System.out.println("Server " + hostName +":"+ port );
            String text = "TIME";
            //String text = vomServer.readLine(); // vom Server empfangen
            //System.out.println(text);         // auf die Konsole schreiben
            //text = vonTastatur.readLine();    // von Tastatur lesen
            System.out.println("schicke zum server: " +text);
            zumServer.println(text);          // zum Server schicken
            //text = vomServer.readLine();      // vom Server empfangen
            //System.out.println(text);         // auf die Konsole schreiben


            // todo HIER OBJEKT EMPFANGEN
            //BufferedReader vomServer = new BufferedReader(new InputStreamReader(c.getInputStream()));
            //BufferedInputStream bis = new BufferedInputStream(c.getInputStream());
            ObjectInputStream ois = new ObjectInputStream(c.getInputStream());
            Object obj = ois.readObject();
            System.out.println("Empfangen: " + obj);
            ois.close();

            // Socket (und damit auch Stroeme) schliessen
            c.close();
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("Aufruf:");
            System.out.println("java DateTimeClientSerialized <HostName> <PortNr>");
        } catch (UnknownHostException ue) {
            System.out.println("Kein DNS-Eintrag fuer " + hostName);
        } catch (IOException e) {
            System.out.println("IO-Error");
        }
    }
}