package MiniPersonenVerwaltung.applikation;
import MiniPersonenVerwaltung.datenModell.DbManager;
import MiniPersonenVerwaltung.datenModell.Person;

public class TestRahmen
{
  public static void main(String[] args)
  {
    // DB-Verbindung aufbauen
    DbManager.openDB();

    //Person.tableCreate();
    //Person.tableInit();

    PersonenListeFrame tFrame = new PersonenListeFrame();
    tFrame.setVisible(true);
  }
}