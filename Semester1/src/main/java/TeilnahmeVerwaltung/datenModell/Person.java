package datenModell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author  Administrator
 */
public class Person
{
  
  //----------------------------------------------------------------------
  // Konstruktoren
  //----------------------------------------------------------------------
  
  //----------------------------------------------------------------------
  // Klassenvariablen
  //----------------------------------------------------------------------
  
  // login id ist die personenId der angemeldeten Person - also
  // der organisierenden Person
  private static Integer loginId;
  
  //----------------------------------------------------------------------
  // Instanz-Variablen
  //----------------------------------------------------------------------
  private Integer personId;
  private String bezeichnung;
  private String kurzzeichen;
  private String email;
  
  //----------------------------------------------------------------------
  // Instanz-Operationen
  //----------------------------------------------------------------------
  
  /**
   * toString Methode
   * Overloading der Operation toString() der Klasse Object
   */
  public String toString()
  {
    // Temporäre Variable innerhalb dieser Operation
    String tString;
    tString = this.getBezeichnung()
            + "   (" 
            + this.getEmail()
            + ", "
            + this.getKurzzeichen()
            + ")"
            ;
    return tString;
  }
  
  
  
  //-----------------------------------------------------------------------
  // getter/setter Methoden
  //-----------------------------------------------------------------------
  
  public String getBezeichnung()
  {
    return bezeichnung;
  }
  public void setBezeichnung(String bezeichnung)
  {
    this.bezeichnung = bezeichnung;
  }

  public String getEmail()
  {
    return email;
  }
  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getKurzzeichen()
  {
    return kurzzeichen;
  }
  public void setKurzzeichen(String kurzzeichen)
  {
    this.kurzzeichen = kurzzeichen;
  }

  public static Integer getLoginId()
  {
    return loginId;
  }
  public static void setLoginId(Integer login_id)
  {
    Person.loginId = login_id;
  }
  
  public Integer getPersonId()
  {
    return personId;
  }
  public void setPersonId(Integer personId)
  {
    this.personId = personId;
  }

  
  // -------------------------------------------------------------------------
  // Datenbank Operationen
  // -------------------------------------------------------------------------
  
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
   * ------------------------------------------------------------------------ 
   * suchenKurzzeichen Methode
   * Person anhand ihres Kurzzeichens suchen und Personenobjekt bereitstellen
   * ------------------------------------------------------------------------
   */
  public Person suchenKurzzeichen(String pKurzzeichen)
  {
    Person tPerson = null;
    try
    {
      // sql befehl als string zusammenbauen
      // ? ist ein platzhalter für eine variable !
      String tString = "select * from person where kurzzeichen=?";
      //
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);
      // jetzt aber noch platzhalter variable füllen
      tStatement.setString(1, pKurzzeichen);
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Tabelle.
      ResultSet tErgebnis = tStatement.executeQuery();
      //
      // 1. Datensatz soll die person enthalten
      // Resultset auf ersten satz setzen wenn möglich
      if (tErgebnis.next())
      {        
        // ein datensatz abarbeiten
        System.out.println("..DB Zugriff : suchenKurzzeichen "
                           +pKurzzeichen);
        System.out.println("..DB Resultat: "
                           +tErgebnis.getString("bezeichnung"));
        tPerson = new Person();
        tPerson.setPersonId(tErgebnis.getInt("person_id"));
        tPerson.setBezeichnung(tErgebnis.getString("bezeichnung"));
        tPerson.setKurzzeichen(tErgebnis.getString("kurzzeichen"));
        tPerson.setEmail(tErgebnis.getString("email"));
      }
      else
      {
        // keine person gefunden
        tPerson = null;
      }      
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("Person.suchenBezeichnung: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-97);      
    }
    
    return tPerson;    
  }  

  /**
   * ------------------------------------------------------------------------ 
   * suchenPersonId Methode
   * Person anhand ihres ID suchen und Personenobjekt bereitstellen
   * ------------------------------------------------------------------------
   */
  public Person suchenPersonId(Integer pPersonId)
  {
    Person tPerson = null;
    try
    {
      // sql befehl als string zusammenbauen
      // ? ist ein platzhalter für eine variable !
      String tString = "select * from person where person_id=?";
      //
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);
      // jetzt aber noch platzhalter variable füllen
      tStatement.setString(1, String.valueOf(pPersonId));
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Tabelle.
      ResultSet tErgebnis = tStatement.executeQuery();
      //
      // 1. Datensatz soll die person enthalten
      // Resultset auf ersten satz setzen wenn möglich
      if (tErgebnis.next())
      {        
        // ein datensatz abarbeiten
        System.out.println("..DB Zugriff : suchenPersonId "
                           +pPersonId);
        System.out.println("..DB Resultat: "
                           +tErgebnis.getString("bezeichnung"));
        tPerson = new Person();
        tPerson.setPersonId(tErgebnis.getInt("person_id"));
        tPerson.setBezeichnung(tErgebnis.getString("bezeichnung"));
        tPerson.setKurzzeichen(tErgebnis.getString("kurzzeichen"));
        tPerson.setEmail(tErgebnis.getString("email"));
      }
      else
      {
        // keine person gefunden
        tPerson = null;
      }      
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("Person.suchenBezeichnung: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-97);      
    }    
    return tPerson;    
  }  

  
} // Ende Klasse