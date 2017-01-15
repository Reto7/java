package Fach_2_Objektorientierung.A10_Exceptions.reto.exceptions;

/**
 * Created by rk on 25.10.16.
 */
public class CheckDigitalException {

    public static void main(String[] args) {
        // Hier wird vom Compilier nichts beanstandet!
        // DigitalException ist eine RuntimeException
        // Diese wird vom Compiler NICHT ueberprueft!
        // Der Aufrufer muss diese also nicht zwingend catchen oder mit throws weitergeben
        check(11);
    }

    public static void check(int z) throws DigitalException {
        /**
         * prueft irgendwas
         */
        if (z>=10) {
            // DigitalException ist eine RuntimeException
            // Diese wird vom Compiler NICHT ueberprueft!
            // Der Aufrufer muss diese also nicht zwingend catchen oder mit throws weitergeben
            DigitalException de = new DigitalException("Hallo");
            throw de;
        }
    }
}
