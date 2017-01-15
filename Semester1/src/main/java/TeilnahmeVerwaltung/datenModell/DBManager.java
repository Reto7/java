package datenModell;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author  Administrator
 */
public class DBManager
{
  // ------------------------------------------------------------------------
  // Klassenvariablen
  // Referenziert auf die jeweiligen Datenbanktreiber
  // ------------------------------------------------------------------------
  private static Connection dbConnection;

  // ------------------------------------------------------------------------
  // Klassenoperationen
  // ------------------------------------------------------------------------
  /**
   * @return  Returns the dbConnection.
   * @uml.property  name="dbConnection"
   */
  public static Connection getDbConnection()
  {
    return dbConnection;
  }

  public static void openDb()
  {
    // Datenbankzugriff muss über try-catch Block erfolgen!
    try
    {
      // Treiber Klassen definieren
      // Ähnlich einem Import, nur dass diese grundsäztlich nicht
      // bekannt sind und somit auch nicht "normal" importiert
      // werden könne. Nachfolgend werden diese geladen...
      Class.forName("com.mysql.jdbc.Driver");

      // Connection herstellen.
      // 1. url des servers, 2. user (root), 3. passwort (hier null)
      dbConnection = DriverManager.getConnection(
          "jdbc:mysql://localhost/teilnahme", "root", "");
      System.out.println("DBManager.openDb: " + dbConnection);
    }
    catch (Exception pException)
    {
      System.out.println("DBManager.openDb: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);
    }
  }

  public static void closeDb()
  {
    // Datenbankzugriff muss über try-catch Block erfolgen!
    try
    {
      dbConnection.close();
      System.out.println("DBManager.closeDb: " + dbConnection);
      dbConnection = null;
    }
    catch (Exception pException)
    {
      System.out.println("DBManager.closeDb: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);
    }
  }

}
