package Fach_7_ClientServerHttp.dateTimeClientUeli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import Fach_7_ClientServerHttp.dateTimeServerUeli.DateTimeInfo;

class DateTimeClient {
    public static void main(String[] args) {
        String hostName = "";   // Rechner-Name bzw. -Adresse
        int port;               // Port-Nummer
        Socket c;               // Socket fuer die Verbindung zum Server

        try {
            hostName = args[0];
            port = Integer.parseInt(args[1]);
            c = new Socket(hostName, port);

            BufferedReader vomServer = new BufferedReader(new InputStreamReader(c.getInputStream()));
            ObjectInputStream vomServerSerializable = new ObjectInputStream(c.getInputStream());
            PrintWriter zumServer = new PrintWriter(c.getOutputStream(),true);

            BufferedReader vonTastatur = new BufferedReader(new InputStreamReader(System.in));

            // Protokoll abwickeln
            System.out.println("Server " + hostName +":"+ port + " sagt:");
            String text = vomServer.readLine(); // vom Server empfangen
            System.out.println(text);         // auf die Konsole schreiben
            text = vonTastatur.readLine();    // von Tastatur lesen
            zumServer.println(text);          // zum Server schicken
            DateTimeInfo info = (DateTimeInfo) vomServerSerializable.readObject();
            System.out.println(info.getInfo());         // auf die Konsole schreiben

            // Socket (und damit auch Stroeme) schliessen
            c.close();
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("Aufruf:");
            System.out.println("java DateTimeClient <HostName> <PortNr>");
        } catch (UnknownHostException ue) {
            System.out.println("Kein DNS-Eintrag fuer " + hostName);
        } catch (IOException e) {
            System.out.println("IO-Error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}