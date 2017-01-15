package Fach_1_Java_Grundlagen.A4;

/**
 * Created by user on 11.09.2016.
 */
public class A_0_Datentypen {

    public static void main(String[] args) {

        short a = 1;
        short b = 2;
      //short c = a + b;  //Incompatible type for declaration. Explicit cast needed to convert int to short.
        short c = (short) (a + b);

        /*
        Um den Ergebnistyp einer arithmetischen Operation zu bestimmen,
        geht der Java-Compiler wie folgt vor:
        Zunächst prüft er, ob einer der Operanden vom Typ double ist – ist dies der
        Fall, so ist der Ergebnistyp dieser Operation double. Der andere Operand
        wird dann (falls notwendig) implizit nach double konvertiert und danach
        die Operation ausgeführt.
        War dies nicht der Fall, prüft der Compiler, ob einer der Operanden vom Typ
        float ist – ist dies der Fall, so ist der Ergebnistyp dieser Operation float.
        Der andere Operand wird (falls erforderlich) dann implizit nach float konvertiert
        und danach die Operation ausgeführt.
        War dies auch nicht der Fall, so prüft der Compiler, ob einer der Operanden
        vom Typ long ist – wenn ja, ist der Ergebnistyp dieser Operation long. Der
        andere Operand wird dann (falls notwendig) implizit nach long konvertiert
        und danach die Operation ausgeführt.
        Trat keiner der drei erstgenannten Fälle ein, so ist der Ergebnistyp dieser Operation
        auf jeden Fall int. Beide Operanden werden dann (falls erforderlich)
        implizit nach int konvertiert und danach die Operation ausgeführt.
         */
    }
    
}
