package MiniPersonenVerwaltung.applikation;

public class startKlasse
{
  public static void main(String[] args)
  {
    int vMaxPers = 2;
//  Integer[] primzahlen = new Integer[5];
//  int arrayOfInts[];
//  arrayOfInts = new int[100];
    
    Programmierer pListe[];
    pListe = new Programmierer[vMaxPers];
    
    pListe[0] = new Programmierer();
    pListe[0].setName("Meier");
    pListe[0].setSprache("Java");
    
    pListe[1] = new Programmierer();
    pListe[1].setName("Mueller");
    pListe[1].setSprache("PL/SQL");
  
    for (int i=0; i<pListe.length; i++)
    {
      System.out.println("-----------------------------");
      System.out.println("Name   : " +pListe[i].getName());
      System.out.println("Sprache: " +pListe[i].getSprache());
    }
  }

}
