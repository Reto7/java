package Fach_2_Objektorientierung.A10_Exceptions.ch.ibw.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exueb6 {
    public static void main(String[] args)
            throws FileNotFoundException {
        FileReader f=new FileReader("/home/rk/IntelliJ-Projekte/Exceptions/src/ch/ibw/exceptions/Exueb6.java");
        try {
            while (true) {
                int c=f.read();
                if (c<0)
                    return;
                System.out.print((char)c);
            }
        }
        catch(IOException e) {}
    }
}