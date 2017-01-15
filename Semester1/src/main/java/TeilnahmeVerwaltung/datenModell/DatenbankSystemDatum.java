package datenModell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatenbankSystemDatum
{
  /**
   * -----------------------------------------------------------------------
   * getDbConnection Methode für Datenbankzugriff
   * -----------------------------------------------------------------------
   */
  private Connection getDbConnection()
  {
    return DBManager.getDbConnection();
  }  
  
  /**
   * ----------------------------------------------------------------------
   * getDbSysdate Methode zum Ermitteln von SYSDATE aus der Datenbank
   * ----------------------------------------------------------------------
   */  
  public String getSysdate()
  {
      String vHeute = "";
      try
      {
        // sql befehl als string zusammenbauen
        String tString = " select DATE_FORMAT(sysdate(),'%d.%m.%Y') as heute from dual";
        System.out.println(tString);
        //
        // Statement auf Basis der Connection erzeugen - mit sql befehl
        // Java Ordner hl-seo: 7-38
        PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);
        // Statement ausführen - an die db senden und auf ergebnis warten
        // Ergebnis ist eine Tabelle.
        ResultSet tErgebnis = tStatement.executeQuery();
        // Schleife über ResultSet - nur sequentielles Lesen möglich!
        while (tErgebnis.next())
        {        
          vHeute = tErgebnis.getString("heute");
          System.out.println("  DB Zugriff SYSDATE: " +vHeute);
        }     
        // Ressourcen freigeben
        System.out.println("Ende DB Zugriff");
        tStatement.close();
      }
      catch(Exception pException)
      {
        System.out.println("Util.getDbSysdate: Fehler: " + pException);
        pException.printStackTrace();
        System.exit(-99);      
      }
      return vHeute;    
    }
}
