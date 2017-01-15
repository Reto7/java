package Fach_2_Objektorientierung.A11_Michele_Generics.enums;

public class Aufzaehlungen {
  public static void main(String[] args) {
    Jahreszeit x = Jahreszeit.HERBST;
    System.out.println(x);
    
    for (Jahreszeit jz : Jahreszeit.values())
      System.out.println(jz + " hat den Wert " + jz.ordinal());
  }
}
