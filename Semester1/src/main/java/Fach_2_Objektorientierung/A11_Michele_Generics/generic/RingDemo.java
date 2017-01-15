package ch.ibw.generic;

/** Erzeugt zehn zufaellige Ringe und sortiert sie */
public class RingDemo {
  public static void main(String[] args) {
    Ring[] ringe = new Ring[10];          // Erzeuge 10 Ringe
    for (int i = 0; i < ringe.length; i++)
      ringe[i] = new Ring(Math.random());
    java.util.Arrays.sort(ringe);         // Sortiere die Ringe
    for (Ring r : ringe)
      System.out.println(r);              // Gib die Ringe aus
  }
}
