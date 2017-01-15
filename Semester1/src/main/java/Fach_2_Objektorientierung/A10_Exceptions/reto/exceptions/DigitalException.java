package Fach_2_Objektorientierung.A10_Exceptions.reto.exceptions;

/**
 * Created by rk on 25.10.16.
 */
public class DigitalException extends RuntimeException {
    // DigitalException ist eine RuntimeException
    // Diese wird vom Compiler NICHT ueberprueft!
    // Der Aufrufer muss diese also nicht zwingend catchen oder mit throws weitergeben

    //constructor
    public DigitalException() {
        // constructor der superklasse aufrufen, also RunTimeException
        super("*** ungueltige Zeichen ***");
    }

    //constructor
    public DigitalException(String str) {
        // constructor der superklasse aufrufen, also RunTimeException
        super(str);
    }
}
