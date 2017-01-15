package Fach_7_ClientServerHttp.DateTimeServerReto.serialized;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class DateTimeServerSerialized {



    public static void main(String[] args) {
        try {

            int port = Integer.parseInt(args[0]);          // Port-Nummer
            ServerSocket server = new ServerSocket(port);  // Server-Socket
            System.out.println("simple.DateTimeServer startet hoch");   // Statusmeldung

            while (true) {
                System.out.println("simple.DateTimeServer läuft");   // Statusmeldung

                // wartet bis verbindungsanforderung kommt!
                final Socket s = server.accept();           // Client-Verbindung akzeptieren

                //new simple.DateTimeProtokoll(s).transact();     // Protokoll abwickeln

                new Thread(new Runnable() {
                    public void run() {
                        // hier geschieht nun etwas innerhalb des Threads
                        System.out.println("Thread gestartet ...");
                        // das hier handelt request/response
                        new DateTimeProtokoll(s).transact();     // Protokoll abwickeln
                    }
                }).start();

            }

        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println("Aufruf: java simple.DateTimeServer <Port-Nr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}