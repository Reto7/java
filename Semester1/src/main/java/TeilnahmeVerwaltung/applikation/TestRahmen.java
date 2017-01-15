package applikation;

public class TestRahmen
{
  public static void main(String[] args)
  {
    // start GUI
    StartFrame tGUI = new StartFrame();
    tGUI.setVisible(true);
    
    
    //  Util.pruefenDatumFormat("20.12.2004");
    
    /*
     * 
     * 
     
    // Test DB Lesen Person Kurzzeichen=KART
    DBManager.openDb();
    Person tPerson = new Person();
    tPerson = tPerson.suchenKurzzeichen("KART");
    System.out.println("Person 1=" +tPerson.getBezeichnung());
    System.out.println();
    
    // Test DB Lesen Person Id=2
    Person tPerson2 = new Person();
    tPerson2 = tPerson2.suchenPersonId(2);
    System.out.println("Person 2=" +tPerson2.getBezeichnung());
    
 
     
    // Künstlich den Organisator PersonId auf 1 setzen!
    
    Person.setLogin_id(1);
    System.out.println("Organisator PersonId=" +Person.getLogin_id());
    
    Ereignis tEreignis1 = new Ereignis("Superznüni", "01.01.2000", "Es gibt nur altes Brot");
    System.out.println("Ereignis: " +tEreignis1);
    
    // Neuer Teilnehmer in DB und gleich auch wieder löschen
    System.out.println("---------------------------------");
    Teilnehmer tTeilnehmer = new Teilnehmer(1,1,"JA","Ich komme wie immer gerne");
    System.out.println("Teilnehmer:" +tTeilnehmer);
    tTeilnehmer.speichern();
    tTeilnehmer.loeschen();
    
    //
    // Neues Ereignis in DB und gleich auch wieder löschen
    System.out.println("---------------------------------");
    Ereignis tEreignis = new Ereignis("Neues Ereignis", null, "nur ein Test");
    System.out.println("Ereignis:" +tEreignis);
    tEreignis.speichern();
    tEreignis.loeschen();
    */
  }

}
