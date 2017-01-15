package datenModell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import applikation.Util;


public class Ereignis
{
  //----------------------------------------------------------------------
  // Konstruktoren
  //----------------------------------------------------------------------
  public Ereignis()
  {
  }
  
  public Ereignis(String pBezeichnung, String pDatum)
  {
    //den eigenen, anderen Konstruktor mit den 3 Parametern aufrufen!!
    this(pBezeichnung, pDatum, null);
  }

  public Ereignis(String pBezeichnung, String pDatum, String pText)
  {
    this.setBezeichnung(pBezeichnung);
    this.setDatum(pDatum);
    this.setBemerkung(pText);
    this.setPersonId(Person.getLoginId());  // Klassenvariable mit Login ID!
    // hier noch ohne ereignis_id !!
  }  
  
  //----------------------------------------------------------------------
  // Instanz-Variablen
  //----------------------------------------------------------------------
  private Integer ereignisId;
  private String bezeichnung = "";
  private String datum = "";  
  private String bemerkung = "";  
  private Integer personId;
  
  //----------------------------------------------------------------------
  // Getter/Setter Methoden
  //----------------------------------------------------------------------  
  public Integer getEreignisId()
  {
    return ereignisId;
  }
  public void setEreignisId(Integer ereignisId)
  {
    this.ereignisId = ereignisId;
  }

  public String getBezeichnung()
  {
    return bezeichnung;
  }
  public void setBezeichnung(String bezeichnung)
  {
    this.bezeichnung = bezeichnung;
  }

  public String getDatum()
  {
    return datum;
  }
  public void setDatum(String datum)
  {
    this.datum = datum;
  }

  public String getBemerkung()
  {
    return bemerkung;
  }
  public void setBemerkung(String bemerkung)
  {
    this.bemerkung = bemerkung;
  }

  public Integer getPersonId()
  {
    return personId;
  }
  public void setPersonId(Integer personId)
  {
    this.personId = personId;
  }

  //----------------------------------------------------------------------
  // Instanz-Operationen
  //----------------------------------------------------------------------
	
  /**
   * --------------------------------------------------------------------
   * getPerson Methode
   * Gibt die Person gemäss personId zurück
   * --------------------------------------------------------------------
   */
  public Person getPerson()
  {
    Person tPerson = new Person();
    tPerson = tPerson.suchenPersonId(this.personId);
    return tPerson;
  }
  
  /**
   * --------------------------------------------------------------------
   * toString Methode aus Klasse "Objekt" überschreiben
   * --------------------------------------------------------------------
   */  
  public String toString()
  {
    return Util.formatString(this.getBezeichnung(), 40)
         + Util.formatString(this.getDatum(), 13)
         + Util.formatString(this.getPerson().getKurzzeichen(),7)
         + Util.formatString(this.getBemerkung(),40)
    ;
  }
  
  /** 
   * --------------------------------------------------------------------
   * anzeige Methode z.B. für Liste in Swing
   * --------------------------------------------------------------------
   */
  /*
  public String anzeige()
  {
    String platzhalter = ".................................................";
    return Util.formatString(this.getBezeichnung() +platzhalter, 40)
         + Util.formatString(" am " +this.getDatum(), 20)
         + Util.formatString(this.getBemerkung() +platzhalter, 40)
         ;
  }
  */
  
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
   * Alle Ereignisse aus Datenbank selektieren und als Arraylist bereitstellen
   * ------------------------------------------------------------------------
   */
  public ArrayList<Ereignis> alleLesen()
  {
    // Leere ArrayList anlegen
    ArrayList<Ereignis> tListe = new ArrayList<Ereignis>();
    try
    {
      // sql befehl als string zusammenbauen
      String tString = "select bezeichnung"
                      +" , ereignis_id"
                      +" , person_id" 
                      +" , DATE_FORMAT(datum,'%d.%m.%Y') as datum"
                      +" , bemerkung"
                      +" , datum as datum_unformatiert"
                      +" from ereignis order by datum_unformatiert desc";
      System.out.println(tString);
      //STR_TO_DATE('2003-15-10','%Y-%m-%d')
      //
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Tabelle.
      ResultSet tErgebnis = tStatement.executeQuery();
      //
      // Aus jeder Zeile ein Ereignisenobjekt erzeugen
      // Ereignisenobjekt in ArrayList einsetzen.
      // Schleife über ResultSet - nur sequentielles Lesen möglich!
      while (tErgebnis.next())
      {        
        // ein datensatz abarbeiten
        System.out.println("  DB Zugriff: " +tErgebnis.getString("bezeichnung"));
        Ereignis tEreignis = new Ereignis();
        tEreignis.setBezeichnung(tErgebnis.getString("bezeichnung"));
        tEreignis.setDatum(tErgebnis.getString("datum"));
        tEreignis.setEreignisId(tErgebnis.getInt("ereignis_id"));
        tEreignis.setPersonId(tErgebnis.getInt("person_id"));
        tEreignis.setBemerkung(tErgebnis.getString("bemerkung"));
        // in ArrayListe füllen
        tListe.add(tEreignis);
      }     
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("Ereignis.alleLesen: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
    return tListe;    
  }
  
  /** 
   * Eigenes Ereignis-Objekt - this - in die Datenbank einfügen
   */
  private void einfuegen()
  {
    try
    {
      // sql befehl als string zusammenbauen
      String tString = "insert into ereignis"
                     + " (bezeichnung, bemerkung, person_id, datum)"
                     + " values(?,?,?,STR_TO_DATE(?,'%d.%m.%Y'))";
      // Möglichk Datum: sysdate() /*STR_TO_DATE('2003-15-10','%Y-%m-%d')*/
      //
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);      
      // jetzt aber noch platzhalter variable füllen
      // ==> wir sind ja ein Objekt und speichern uns selbst ab! was denn sonst !!
      tStatement.setString(1, this.getBezeichnung());
      tStatement.setString(2, this.getBemerkung());
      tStatement.setInt(3, Person.getLoginId());   //this.getPersonId());
      tStatement.setString(4, this.getDatum());
      //
      System.out.println("Statement:" +tStatement);
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Integer Zahl!
      Integer tErgebnis = tStatement.executeUpdate();
      System.out.println("Insert in DB (ereignis): " +tErgebnis +" Rows");
      //
      // Ressourcen freigeben
      tStatement.close();
      //
      //    --------------------------------------------------------------------
      // --> etwas unschön -- wir müssen jetzt ja noch wissen welche
      //     ereignis_id wir von der db bekommen haben.
      //     wird benötigt wenn z.B. wir dieses objekt gleich wieder
      //     loeschen möchten (löschen by ereignis_id!)
      try
        {
          // sql befehl als string zusammenbauen
          // ...wird wohl eindeutig sein....
          tString = "select * from ereignis t"
                     + " where bezeichnung=?"
                     + " and bemerkung=?"
                     + " and person_id=?"
                     + " and DATE_FORMAT(datum,'%Y-%m-%d') = DATE_FORMAT(sysdate(),'%Y-%m-%d')" 
                     + " and ereignis_id = (select max(ereignis_id)"
                     +                     "  from ereignis"
                     +                     "  where bezeichnung=t.bezeichnung"
                     +                     "  and   bemerkung=t.bemerkung"
                     +                     "  and   person_id=t.person_id"
                     +                     "  and   datum=t.datum)"
                     ;
          //
          // Statement auf Basis der Connection erzeugen - mit sql befehl
          // Java Ordner hl-seo: 7-38
          tStatement = this.getDbConnection().prepareStatement(tString);
          // jetzt aber noch platzhalter variable füllen
          tStatement.setString(1, this.getBezeichnung());
          tStatement.setString(2, this.getBemerkung());
          tStatement.setInt(3, Person.getLoginId());   //this.getPersonId());
          //tStatement.setString(4, this.getDatum());
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
            System.out.println("  DB Zugriff (ereignis): " +tErgebnisResult.getString("ereignis_id"));
            this.setEreignisId(tErgebnisResult.getInt("ereignis_id"));
            System.out.println("  Neue EreignisId=" +this.getEreignisId());
          }
          else
          {
            // keine neue EreignisId gefunden
            // oje .........................................
            // oje .........................................
            System.out.println("................. keine EreignisId gefunden .................");
          }
          
          // Ressourcen freigeben
          tStatement.close();
        }
        catch(Exception pException)
        {
          System.out.println("Ereignis.einfuegen.sucheNeueEreignisId: Fehler: " + pException);
          pException.printStackTrace();
          System.exit(-97);      
        }
        //--------------------------------------------------------------------
    }
    catch(Exception pException)
    {
      System.out.println("Ereignis.einfuegen: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
  }
   
  /**
   * ------------------------------------------------------------------------
   * Änderungen des eigenen Personen Objektes in der Datenbank aktualisieren
   * ------------------------------------------------------------------------
   */
  private void aendern()  
  {    
    try
    {
      // sql befehl als string zusammenbauen
      String tString = "update ereignis"
                     + "  set bezeichnung=?"
                     + " ,bemerkung=?"
                     + " ,person_id=?"
                     + " ,datum=STR_TO_DATE(?,'%d.%m.%Y')"
//                   + " ,datum=sysdate()"                     
                     + " where ereignis_id=?"
                     ;
      // Möglichk Datum: sysdate() /*STR_TO_DATE('2003-15-10','%Y-%m-%d')*/
      //
      System.out.println("----------------------------");
      System.out.println(tString);
      System.out.println("Datenlage vor Update Ereignis:");
      System.out.println("bez   = " +this.getBezeichnung());
      System.out.println("bem   = " +this.getBemerkung());
      System.out.println("pers  = " +this.getPersonId());
      System.out.println("datum = " +this.getDatum());
      System.out.println("er_id = " +this.getEreignisId());
      
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);      
      // jetzt aber noch platzhalter variable füllen
      // ==> wir sind ja ein Objekt und speichern uns selbst ab! was denn sonst !!
      tStatement.setString(1, this.getBezeichnung());
      tStatement.setString(2, this.getBemerkung());
      tStatement.setInt(3, Person.getLoginId()); //this.getPersonId());
      tStatement.setString(4, this.getDatum());
      tStatement.setInt(5, this.getEreignisId());
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Integer Zahl!
      Integer tErgebnis = tStatement.executeUpdate();
      System.out.println("Update in DB (ereignis): " +tErgebnis +" Rows");
      //
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("Ereignis.aendern: Fehler: " + pException);
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
    // Pruefen ob EreignisId gesetzt ist, wenn ja ändern, wenn nein dann neue berechn.
    if (this.getEreignisId() instanceof Integer)
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
      String tString = "delete from ereignis where ereignis_id=?";
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);      
      // jetzt aber noch platzhalter variable füllen
      // ==> wir sind ja ein Objekt und speichern uns selbst ab! was denn sonst !!
      tStatement.setInt(1, this.getEreignisId());
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Integer Zahl!
      Integer tErgebnis = tStatement.executeUpdate();
      System.out.println("Delete in DB (ereignis): " +tErgebnis +" Rows");
      //
      // Ressourcen freigeben
      tStatement.close();
    }    
    catch(SQLException pSQLError)
    {
      System.out.println("*************************************");
      System.out.println("Ereignis.loeschen: Fehler: " + pSQLError.toString());
      System.out.println("Errorcode=" +pSQLError.getErrorCode());
      System.out.println("*************************************");
      // Wenn Code 1217 : java.sql.SQLException: 
      // Cannot delete or update a parent row: a foreign key constraint fails
    }
    catch(Exception pException)
    {
      System.out.println("*************************************");
      System.out.println("Ereignis.loeschen: Fehler: " + pException.toString());
      pException.printStackTrace();
      System.exit(-99);      
    } 
  }
  
  /**
   * getAnzahlTeilnehmer Methode zum Ermitteln der Teilnehmer für ein Ereignis
   * wäre eine Klassenmethode (static) da sie ja nicht für ein einzelnes Objekt,
   * sondern für die ganze Klasse Informationen ermittelt. Jedoch erlaubt dies
   * die getDbConnection() Methode wiederum nicht ...?! 
   * Erwartet wird zwingend: 
   * a) ein Teilnehmerstatus wie: JA,NEIN,OFFEN
   */
  public Integer getAnzahlTeilnehmer(String pStatus)
  {
    Integer vReturn=0;
    try
    {
      
      String tString;     
      PreparedStatement tStatement = null;
      //
      if (pStatus == "JA" || pStatus == "NEIN")
      {
        // sql befehl als string zusammenbauen
        tString =   "select count(*) as anzahl"
                  + " from teilnehmer "
                  + " where ereignis_id=?"
                  + " and status=?";
        // Statement auf Basis der Connection erzeugen - mit sql befehl
        // Java Ordner hl-seo: 7-38
        tStatement = this.getDbConnection().prepareStatement(tString);      
        // jetzt aber noch platzhalter variable füllen
        // ==> wir sind ja ein Objekt und speichern uns selbst ab! was denn sonst !!
        tStatement.setInt(1, this.getEreignisId());
        tStatement.setString(2, pStatus);
      }
      // sonst halt alle offenen ermitteln
      else 
      {
        // sql befehl als string zusammenbauen
        tString = "select count(*) as anzahl"
                + " from person p"
                + "    where not exists ("
                + "     select 1"
                + "     from ereignis e   "
                + "       ,  teilnehmer t "
                + "     where e.ereignis_id  = ? "
                + "     and e.ereignis_id = t.ereignis_id"
                + "     and t.person_id = p.person_id)"
                ;
        // Statement auf Basis der Connection erzeugen - mit sql befehl
        // Java Ordner hl-seo: 7-38
        tStatement = this.getDbConnection().prepareStatement(tString);      
        // jetzt aber noch platzhalter variable füllen
        // ==> wir sind ja ein Objekt und speichern uns selbst ab! was denn sonst !!
        tStatement.setInt(1, this.getEreignisId());
      }
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Tabelle.
      ResultSet tErgebnisResult = tStatement.executeQuery();
      //
      // 1. Datensatz soll die person enthalten
      // Resultset auf ersten satz setzen wenn möglich
      if (tErgebnisResult.next())
      {        
        // ein datensatz abarbeiten
        System.out.println("  DB Zugriff (teilnehmer.getAnzahlTeilnehmer) ER=" 
                          +this.getEreignisId()
                          +" Status="
                          +pStatus);
        vReturn = Integer.parseInt(tErgebnisResult.getString("anzahl"));
      }
      else
      {
        // keine Teilnehmer Rows gefunden
        // Kann eigentlich nicht sein da COUTN(*) sowieso 0 zurückbringt...
        vReturn = 0;
      }
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
    //
    return(vReturn);
  }
  
  
} // end Class
