package Fach_2_Objektorientierung.A84_Klang_Theorieaufgabe;

/*
Aufgabe 8.4
        Vervollst¨andigen Sie den nachfolgenden L¨ uckentext mit Angaben, die sich auf
        die Klassen Klang, Krach und Musik beziehen, die am Ende dieser Aufgabe angegeben sind:
        a) Die Klasse KLANG ist Superklasse der Klasse KRACH
        b) Die Klasse KRACH erbt von der Klasse KLANG die Variable(n) BAESSE, HOHEN
        c) In den drei Klassen gibt es die Instanzvariable(n) RAUSCHEN, LAUTSTAERKE, BAESSE, HOEHEN
        d) In den drei Klassen gibt es die Klassenvariable(n) GRUNDRAUSCHEN
        e) Auf die Variable(n) BAESSE, HOHEN der Klasse Klang kann in der Klasse Krach und in der
        Klasse Musik zugegriffen werden.
        f) Auf die Variable(n) RAUSCHEN, LAUTSTAERKE der Klasse Krach hat keine andere Klasse Zugriff.
        g) Die Variable(n) GRUNDRAUSCHEN hat/haben in allen Instanzen der Klasse Krach den gleichen
        Wert --> 4
        h) Der Konstruktor der Klasse Klang wird in den Zeilen 18 UND 35 aufgerufen.
        i) Die Methode mehrPower der Klasse Klang wird in den Zeilen 22 BIS 26 uberschrieben
        und in den Zeilen 28 BIS 31 uberladen.
        j) Die Methode mehrPower, die in den Zeilen 22 BIS 26 definiert ist, wird in
        Zeile 30 und in Zeile 38 aufgerufen.
        k) Die Methode mehrPower, die in den Zeilen 28 BIS 31 definiert ist, wird in
        Zeile 39 aufgerufen.
        l) Die Methode mehrPower, die in den Zeilen 10 BIS 12 definiert ist, wird in NIEMALS
        aufgerufen.
        m) Die Methode toString, die in den Zeilen 7 bis 9 definiert ist, wird in MUSIK, ZEILE 37 aufgerufen.
        n) Die Methoden MEHRPOWER UND TOSTRING sind Instanzmethoden.

        Auf die nachfolgenden Klassen sollen sich Ihre Antworten beziehen:
*/
public class Klang {

    /* instanzvar */
    public int baesse, hoehen;

    /* constructor */
    public Klang(int b, int h) {
        baesse = b;
        hoehen = h;
    }

    public String toString() {
        return "B:" + baesse + " H:" + hoehen;
    }

    public void mehrPower(int b) {
         baesse += b;
    }
}

/*
1 public class Klang {
2 public int baesse, hoehen;
3 public Klang(int b, int h) {
4 baesse = b;
5 hoehen = h;
6 }
7 public String toString () {
8 return "B:" + baesse + " H:" + hoehen;
9 }
10 public void mehrPower (int b) {
11 baesse += b;
12 }
13 }
14 public class Krach extends Klang {
15 private int rauschen, lautstaerke;
16 public static int grundRauschen = 4;
17 public Krach (int l, int b, int h) {
18 super(b,h);
19 lautstaerke = l;
20 rauschen = grundRauschen;
21 }
22 public void mehrPower (int b) {
23 baesse += b;
24 if (baesse > 10) {
25 lautstaerke -= 1;
26 }
27 }
28 public void mehrPower (int l, int b) {
29 lautstaerke += l;
30 this.mehrPower(b);
31 }
32 }
33 public class Musik {
34 public static void main (String[] args) {
35 Klang k = new Klang(1,5);
36 Krach r = new Krach(4,17,30);
37 System.out.println(r);
38 r.mehrPower(3);
39 r.mehrPower(2,2);
40 }
41 }

 */