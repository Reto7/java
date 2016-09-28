package Fach_1_Java_Grundlagen.A5;

/**
 * Created by user on 11.09.2016.
 */
public class A_5_2_ArrayVergleich {
    public static void main(String[] args) {
        int[] a = {1,7,3};
        int[] b = {1,2,3};

        // Einfacher Vergleich geht nicht
        // Mit a == b vergleicht man nur die Referenzen
        //  Sind diese gleich, so kann man zwar schließen, daß die beiden Felder identisch sind (tatsächlich handelt es
        //  sich ja nur um eines), sind diese aber ungleich, so können die Feldinhalte dennoch gleich sein.
        //
        // a ---> 1 2 3
        //    +->
        // b -+
        //
        // a ---> 1 2 3
        // b ---> 1 2 3

        VergleichsMarke:
        if (a.length == b.length) {
            // vergleich jedes Array Element
            for (int i = 0; i<a.length; i++){
                if (a[i] != b[i]) {
                    System.out.println("ungleich, Werte auf Position " +i +" stimmen nicht überein: " + a[i] + " und " + b[i]);
                      break VergleichsMarke;
                }
            }
            // falls ungleich haben wir diesen if bereits mit dem break auf die Marke verlassen!
            System.out.println("Die Arrays sind gleich!");
        }
        else {
            System.out.println("ungleich, die Array-Länge stimmt nicht überein");
        }

    }
}
