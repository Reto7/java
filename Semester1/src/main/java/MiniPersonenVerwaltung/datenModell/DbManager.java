package MiniPersonenVerwaltung.datenModell;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbManager
{
	// Klassen-Variable

  private static Connection dbConnection; // Verbindung zur Datenbank

  /*
   * Auswahl des Datenbank-Typs und der Datenbank
   */
  private static String dbSelektion = "postgres";
  //private static String dbSelektion = "mySql";

  // ***************************************************************************
  // Klassen-Operationen
  // ***************************************************************************


  public static Connection getDbConnection()
  {
    return dbConnection;
  }

  public static String getDbSelektion()
  {
    return dbSelektion;
  }

  // ***************************************************************************
  // Datenbank-Operationen
  // ***************************************************************************

  // ---------------------------------------------------------------------------
  public static void openDB()
  {
    // Verbindung zur Datenbank aufbauen

    try
    {
      if (dbSelektion == "Access")
      {
    	  // Driver-Manager
    	  DriverManager.setLogWriter( new java.io.PrintWriter(System.out) );	  
    	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	  dbConnection = DriverManager.getConnection("jdbc:odbc:JSPPersonDB");
    	  System.out.println("openDB: Access-dbConnection=" + dbConnection);
      }
      else if (dbSelektion == "mySql")
      {
    	  // Driver-Manager
    	  DriverManager.setLogWriter( new java.io.PrintWriter(System.out) );
    	  Class.forName("com.mysql.jdbc.Driver");
    	  dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gen_PersonKonto","root","root");
    	  System.out.println("openDB: mySql-dbConnection =" + dbConnection);
      }
      else if (dbSelektion == "postgres")
      {
        // Driver-Manager
        DriverManager.setLogWriter( new java.io.PrintWriter(System.out) );
        //Treiber wird geladen und im DriverManager registriert.
        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost/reto", "postgres","postgres");
        System.out.println("openDB: postgresql-dbConnection =" + dbConnection);
      }
      else
      {
    	  dbConnection = null;
    	  System.out.println("openDB: ????-dbConnection=" + dbConnection);
      } 	  
   	
    }
    catch (Exception pException)
    {
      System.out.println("Fehler bei openDb: " + pException);
    }
  }

  // ---------------------------------------------------------------------------
  public static void closeDB()
  {
    // Verbindung zur Datenbank abbauen
    try
    {
      dbConnection.close();
    }
    catch (Exception pException)
    {
      System.out.println("Fehler bei closeDb: " + pException);
    }
  }

  // ---------------------------------------------------------------------------

} // Ende Klasse