package datenModell;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import applikation.Util;


public class Teilnehmer
{
  //----------------------------------------------------------------------
  // Konstruktoren
  //----------------------------------------------------------------------
  public Teilnehmer()
  {
  }

  public Teilnehmer(Integer pEreignisId
                   ,Integer pPersonId  )
  {
    //den eigenen, anderen Konstruktor mit den 4 Parametern aufrufen!!
    this(pEreignisId, pPersonId, null, null);
  }
  
  public Teilnehmer( Integer pEreignisId
                    ,Integer pPersonId
                    ,String pStatus  )
  {
    //den eigenen, anderen Konstruktor mit den 4 Parametern aufrufen!!
    this(pEreignisId, pPersonId, pStatus, null);
  }

  public Teilnehmer(Integer pEreignisId
                   ,Integer pPersonId
                   ,String pStatus                   
                   ,String pFreitext )
  {
    this.setFreitext(pFreitext);
    this.setPersonId(pPersonId);
    this.setEreignisId(pEreignisId);
    this.setStatus(pStatus);
    // hier noch ohne teilnehmer_id !! -- wird db seitig vergeben...
  }  
    
  
  //----------------------------------------------------------------------
  // Instanz-Variablen
  //----------------------------------------------------------------------
  private Integer teilnehmerId;
  private String freitext = "";
  private String status = "";
  private Integer personId;
  private Integer ereignisId;
  
  //-----------------------------------------------------------------------
  // getter/setter Methoden
  //-----------------------------------------------------------------------
  public Integer getTeilnehmerId()
  {
    return teilnehmerId;
  }
  public void setTeilnehmerId(Integer teilnehmerId)
  {
    this.teilnehmerId = teilnehmerId;
  }

  public String getFreitext()
  {
    return freitext;
  }
  public void setFreitext(String freitext)
  {
    this.freitext = freitext;
  }

  public String getStatus()
  {
    return status;
  }
  public void setStatus(String status)
  {
    this.status = status;
  }

  public Integer getPersonId()
  {
    return personId;
  }
  public void setPersonId(Integer personId)
  {
    this.personId = personId;
  }

  public Integer getEreignisId()
  {
    return ereignisId;
  }
  public void setEreignisId(Integer ereignisId)
  {
    this.ereignisId = ereignisId;
  }

  
  //----------------------------------------------------------------------
  // Instanz-Operationen
  //----------------------------------------------------------------------

  /**
   * ---------------------------------------------------------------------
   * getPerson Methode: Rückgabe eines Personenobjekts
   * ---------------------------------------------------------------------
   */
  public Person getPerson()
  {
    Person tPerson = new Person();
    tPerson = tPerson.suchenPersonId(this.personId);
    return tPerson;
  }
  
  /**
   * --------------------------------------------------------------------
   * getEreignis Methode: Rückgabe eines Ereignis-Objekts 
   * --------------------------------------------------------------------
   */
  // wird aber zur Zeit noch nicht benötigt ....
  public Ereignis getEreignis()
  {
    return null;
    //Ereignis tEreignis = new Ereignis();
    //tEreignis = tEreignis.suchenEreignisId(this.ereignisId);
    //return tEreignis;
  }
  
  /**
   * --------------------------------------------------------------------
   * toString Methode aus Klasse "Objekt" überschreiben
   * --------------------------------------------------------------------
   */  
  public String toString()
  {
    String vAnzeige = Util.formatString(this.getStatus(), 8)
                    + Util.formatString(this.getPerson().getBezeichnung(), 20)
                    + Util.formatString(this.getFreitext(),40)
                    ;    
    return(vAnzeige);   
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
   * Alle Teilnehmer aus Datenbank selektieren 
   * und als Arraylist bereitstellen
   * ------------------------------------------------------------------------
   */
  public ArrayList<Teilnehmer> alleLesen()
  {
    // Leere ArrayList anlegen
    ArrayList<Teilnehmer> tListe = new ArrayList<Teilnehmer>();
    try
    {
      // sql befehl als string zusammenbauen
      String tString = "select teilnehmer_id"
                      +" , ereignis_id"
                      +" , person_id" 
                      +" , status"
                      +" , freitext"
                      +" from teilnehmer order by ereignis_id";
      System.out.println(tString);
      //
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Tabelle.
      ResultSet tErgebnis = tStatement.executeQuery();
      //
      // Aus jeder Zeile ein Teilnehmerenobjekt erzeugen
      // Teilnehmerenobjekt in ArrayList einsetzen.
      // Schleife über ResultSet - nur sequentielles Lesen möglich!
      while (tErgebnis.next())
      {        
        // ein datensatz abarbeiten
        System.out.println("  DB Zugriff auf Teilnehmer, id: " +tErgebnis.getString("teilnehmer_id"));
        Teilnehmer tTeilnehmer = new Teilnehmer();
        tTeilnehmer.setFreitext(tErgebnis.getString("freitext"));
        tTeilnehmer.setEreignisId(tErgebnis.getInt("ereignis_id"));
        tTeilnehmer.setTeilnehmerId(tErgebnis.getInt("teilnehmer_id"));
        tTeilnehmer.setPersonId(tErgebnis.getInt("person_id"));
        tTeilnehmer.setStatus(tErgebnis.getString("status"));
        // in ArrayListe füllen
        tListe.add(tTeilnehmer);
      }     
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("Teilnehmer.alleLesen: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
    return tListe;    
  }

  /**
   * ------------------------------------------------------------------------
   * Alle Teilnehmer nach ereignis_id aus Datenbank selektieren 
   * und als Arraylist bereitstellen
   * ------------------------------------------------------------------------
   */
  public ArrayList<Teilnehmer> alleLesenByEreignisId(Integer pEreignisId)
  {
    // Leere ArrayList anlegen
    ArrayList<Teilnehmer> tListe = new ArrayList<Teilnehmer>();
    try
    {
      // sql befehl als string zusammenbauen
/*      
      String tString =  "select p.person_id"
        +"     , p.kurzzeichen"
        +"     , p.bezeichnung"
        +"     , p.email"
        +"     , t.teilnehmer_id"
        +"     , t.status"
        +"     , t.freitext"
        +"     , t.ereignis_id"
        +" from person as p"
        +" left outer join teilnehmer as t using (person_id)"
        +" where ereignis_id = ?"
        +"                     " 
        +"   UNION             " 
        +"                     " 
        +" select p.person_id"
        +"     , p.kurzzeichen"
        +"     , p.bezeichnung"
        +"     , p.email"
        +"     , null"
        +"     , null"
        +"     , null"
        +"     , null"
        +" from person as p"
        +" where not exists (select 1"
        +"                  from teilnehmer"
        +"                  where person_id = p.person_id"
        +"                  and ereignis_id = ?)"
        +" order by bezeichnung"
        ;
*/
      // Der Join auf Person wird nur wegen der Sortierung benötigt
      // Könnte ansonsten hier entfernt werden !
      String tString = "select t.teilnehmer_id"
                      +" , t.ereignis_id"
                      +" , t.person_id" 
                      +" , t.status"
                      +" , t.freitext"
                      +" from teilnehmer t"
                      +"     ,person     p"
                      +" where ereignis_id = ?"
                      +" and t.person_id = p.person_id"
                      +" order by t.status, p.bezeichnung";
   
      System.out.println(tString);
      //
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);
      // jetzt aber noch platzhalter variable füllen
      // ==> wir sind ja ein Objekt und speichern uns selbst ab! was denn sonst !!
      tStatement.setInt(1, pEreignisId);      
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Tabelle.
      ResultSet tErgebnis = tStatement.executeQuery();
      //
      // Aus jeder Zeile ein Teilnehmerenobjekt erzeugen
      // Teilnehmerenobjekt in ArrayList einsetzen.
      // Schleife über ResultSet - nur sequentielles Lesen möglich!
      while (tErgebnis.next())
      {        
        // ein datensatz abarbeiten
        System.out.println("  DB Zugriff auf Teilnehmer, id: " +tErgebnis.getString("teilnehmer_id"));
        Teilnehmer tTeilnehmer = new Teilnehmer();
        tTeilnehmer.setFreitext(tErgebnis.getString("freitext"));
        tTeilnehmer.setEreignisId(tErgebnis.getInt("ereignis_id"));
        tTeilnehmer.setTeilnehmerId(tErgebnis.getInt("teilnehmer_id"));
        tTeilnehmer.setPersonId(tErgebnis.getInt("person_id"));
        tTeilnehmer.setStatus(tErgebnis.getString("status"));
        // in ArrayListe füllen
        tListe.add(tTeilnehmer);
      }     
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("Teilnehmer.alleLesen: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
    return tListe;    
  }

  
  
  /** 
   * ------------------------------------------------------------------
   * Eigenes Teilnehmer-Objekt - this - in die Datenbank einfügen
   * ------------------------------------------------------------------
   */
  private void einfuegen()
  {
    try
    {
      // sql befehl als string zusammenbauen
      String tString = "insert into teilnehmer"
                     + " (freitext, status, person_id, ereignis_id)"
                     + " values(?,?,?,?)";
      //
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);      
      // jetzt aber noch platzhalter variable füllen
      // ==> wir sind ja ein Objekt und speichern uns selbst ab! was denn sonst !!
      tStatement.setString(1, this.getFreitext());
      tStatement.setString(2, this.getStatus());
      tStatement.setInt(3, this.getPersonId());
      tStatement.setInt(4, this.getEreignisId());
      //
      System.out.println("Statement:" +tStatement);
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Integer Zahl!
      Integer tErgebnis = tStatement.executeUpdate();
      System.out.println("Insert in DB (teilnehmer): " +tErgebnis +" Rows");
      //
      // Ressourcen freigeben
      tStatement.close();
      //
      //    --------------------------------------------------------------------
      // --> etwas unschön -- wir müssen jetzt ja noch wissen welche
      //     teilnehmer_id wir von der db bekommen haben.
      //     wird benötigt wenn z.B. wir dieses objekt gleich wieder
      //     loeschen möchten (löschen by teilnehmer_id!)
      try
        {
          // sql befehl als string zusammenbauen
          // ...wird wohl eindeutig sein....
          tString = "select * from teilnehmer t"
                     + " where freitext=?"
                     + " and status=?"
                     + " and person_id=?"
                     + " and ereignis_id=?" 
                     + " and teilnehmer_id = (select max(teilnehmer_id)"
                     +                     "  from teilnehmer"
                     +                     "  where freitext=t.freitext"
                     +                     "  and   status=t.status"
                     +                     "  and   person_id=t.person_id"
                     +                     "  and   ereignis_id=t.ereignis_id)"
                     ;
          //
          // Statement auf Basis der Connection erzeugen - mit sql befehl
          // Java Ordner hl-seo: 7-38
          tStatement = this.getDbConnection().prepareStatement(tString);
          // jetzt aber noch platzhalter variable füllen
          tStatement.setString(1, this.getFreitext());
          tStatement.setString(2, this.getStatus());
          tStatement.setInt(3, this.getPersonId());
          tStatement.setInt(4, this.getEreignisId());
          //
          // Statement ausführen - an die db senden und auf ergebnis warten
          // Ergebnis ist eine Tabelle.
          ResultSet tErgebnisResult = tStatement.executeQuery();
          //
          // 1. Datensatz soll die person enthalten
          // Resultset auf ersten satz setzen wenn möglich
          if (tErgebnisResult.next())
          {        
            // ein datensatz abarbeiten
            System.out.println("  DB Zugriff (teilnehmer): " +tErgebnisResult.getString("teilnehmer_id"));
            this.setTeilnehmerId(tErgebnisResult.getInt("teilnehmer_id"));
            System.out.println("  Neue TeilnehmerId=" +this.getTeilnehmerId());
          }
          else
          {
            // keine neue TeilnehmerId gefunden
            // oje .........................................
            // oje .........................................
            System.out.println("................. keine TeilnehmerId gefunden .................");
          }
          
          // Ressourcen freigeben
          tStatement.close();
        }
        catch(Exception pException)
        {
          System.out.println("Teilnehmer.einfuegen.sucheNeueTeilnehmerId: Fehler: " + pException);
          pException.printStackTrace();
          System.exit(-97);      
        }
        //--------------------------------------------------------------------
    }
    catch(Exception pException)
    {
      System.out.println("Teilnehmer.einfuegen: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
  }
   
  /**
   * ------------------------------------------------------------------------
   * Änderungen des eigenen Teilnehmer Objektes in der Datenbank aktualisieren
   * ------------------------------------------------------------------------
   */
  private void aendern()  
  {
    try
    {
      // sql befehl als string zusammenbauen
      String tString = "update teilnehmer"
                     + " set freitext=?"
                     + " ,status=?"
                     + " ,person_id=?"
                     + " ,ereignis_id=?"
                     + " where teilnehmer_id=?"
                     ;
      //
      System.out.println("----------------------------");
      System.out.println(tString);
      System.out.println("Datenlage vor Update Teilnehmer:");
      System.out.println("txt   = " +this.getFreitext());
      System.out.println("stat  = " +this.getStatus());
      System.out.println("pers  = " +this.getPersonId());
      System.out.println("ereig = " +this.getEreignisId());
      System.out.println("teilid= " +this.getTeilnehmerId());
      
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);      
      // jetzt aber noch platzhalter variable füllen
      // ==> wir sind ja ein Objekt und speichern uns selbst ab! was denn sonst !!
      tStatement.setString(1, this.getFreitext());
      tStatement.setString(2, this.getStatus());
      tStatement.setInt(3, this.getPersonId());
      tStatement.setInt(4, this.getEreignisId());
      tStatement.setInt(5, this.getTeilnehmerId());
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Integer Zahl!
      Integer tErgebnis = tStatement.executeUpdate();
      System.out.println("Update in DB (teilnehmer): " +tErgebnis +" Rows");
      //
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("Teilnehmer.aendern: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
  }   
  
  /**
   * ------------------------------------------------------------------------
   * Objekt "dauerhaft" speichern --> Neue Objekte einfügen, vorhandene ändern
   * ------------------------------------------------------------------------
   */
  public void speichern()
  {
    // Pruefen ob TeilnehmerId gesetzt ist, wenn ja ändern, wenn nein dann neue berechn.
    if (this.getTeilnehmerId() instanceof Integer)
    {
      this.aendern();
    }
    else
    {
      //this.setOid(this.getNeueOid());
      this.einfuegen();
    }
   }
  
  /**
   * ------------------------------------------------------------------------
   * Objekt dauerhaft löschen
   * ------------------------------------------------------------------------ 
   */
  public void loeschen()
  {
    try
    {
      // sql befehl als string zusammenbauen
      String tString = "delete from teilnehmer where teilnehmer_id=?";
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);      
      // jetzt aber noch platzhalter variable füllen
      // ==> wir sind ja ein Objekt und speichern uns selbst ab! was denn sonst !!
      tStatement.setInt(1, this.getTeilnehmerId());
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Integer Zahl!
      Integer tErgebnis = tStatement.executeUpdate();
      System.out.println("Delete in DB (teilnehmer): " +tErgebnis +" Rows");
      //
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("Person.loeschen: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-96);      
    }  
  }
 
} // end Class
