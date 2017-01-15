package datenModell;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import applikation.Util;

public class TeilnehmerEreignis
{
  
  //----------------------------------------------------------------------
  // Instanz-Variablen
  //----------------------------------------------------------------------
  private Integer teilnehmerId;
  private Integer teilnehmerPersonId;
  private String teilnehmerFreitext;  
  private Integer teilnehmerErkennung;
  private String teilnehmerStatus;
  private Integer ereignisOrganisatorPersonId;
  private Integer ereignisId;
  private String ereignisBezeichnung = "";
  private String ereignisDatum = "";
  private String ereignisBemerkung = "";  

  //-----------------------------------------------------------------------
  // Setter/Getter Methoden
  //-----------------------------------------------------------------------  
  public Integer getEreignisId()
  {
    return ereignisId;
  }
  public void setEreignisId(Integer ereignisId)
  {
    this.ereignisId = ereignisId;
  }

  public String getEreignisBezeichnung()
  {
    return ereignisBezeichnung;
  }
  public void setEreignisBezeichnung(String bezeichnung)
  {
    this.ereignisBezeichnung = bezeichnung;
  }

  public String getEreignisDatum()
  {
    return ereignisDatum;
  }
  public void setEreignisDatum(String datum)
  {
    this.ereignisDatum = datum;
  }

  public String getEreignisBemerkung()
  {
    return ereignisBemerkung;
  }
  public void setEreignisBemerkung(String bemerkung)
  {
    this.ereignisBemerkung = bemerkung;
  }

  public Integer getTeilnehmerPersonId()
  {
    return teilnehmerPersonId;
  }
  public void setTeilnehmerPersonId(Integer personId)
  {
    this.teilnehmerPersonId = personId;
  }

  
  public Integer getEreignisOrganisatorPersonId()
  {
    return ereignisOrganisatorPersonId;
  }
  public void setEreignisOrganisatorPersonId(Integer ereignisOrganisatorPersonId)
  {
    this.ereignisOrganisatorPersonId = ereignisOrganisatorPersonId;
  }

  public String getTeilnehmerFreitext()
  {
    return teilnehmerFreitext;
  }
  public void setTeilnehmerFreitext(String teilnehmerFreitext)
  {
    this.teilnehmerFreitext = teilnehmerFreitext;
  }

  public Integer getTeilnehmerId()
  {
    return teilnehmerId;
  }
  public void setTeilnehmerId(Integer teilnehmerId)
  {
    this.teilnehmerId = teilnehmerId;
  }

  public String getTeilnehmerStatus()
  {
    return teilnehmerStatus;
  }
  public void setTeilnehmerStatus(String teilnehmerStatus)
  {
    this.teilnehmerStatus = teilnehmerStatus;
  }

  public Integer getTeilnehmerErkennung()
  {
    return teilnehmerErkennung;
  }
  public void setTeilnehmerErkennung(Integer teilnehmerErkennung)
  {
    this.teilnehmerErkennung = teilnehmerErkennung;
  }

  //----------------------------------------------------------------------
  // Instanz-Operationen
  //----------------------------------------------------------------------

  /**
   * ---------------------------------------------------------------------
   * toString Methode aus Klasse "Objekt" überschreiben
   * ---------------------------------------------------------------------
   */  
  public String toString()
  {
      String vTeilnahme = "";
      String vFreitext = "";
      String vAnzeige;
      // check ob dieses Objekt zum Ereignis auch noch eine Teilnahme besitzt.
      if (this.getTeilnehmerErkennung().equals(1))
      {      
        //System.out.println("Mit Teilnahme !!!!!!!!!!!!!!!!!!!");
        if(this.getTeilnehmerStatus().equals("JA")
         ||this.getTeilnehmerStatus().equals("NEIN"))
        {
          vTeilnahme = this.getTeilnehmerStatus();
          vFreitext = "" +this.getTeilnehmerFreitext();
        }
        else
        {
          vTeilnahme = "--?--";
          vFreitext = "";
        }
      }
      else
        System.out.println("Das Ereignis " +this.getEreignisBezeichnung()
            +" hat vom angemeldeten User noch keinerlei Teilnahme.");
      //  
      String plh = "..........................................................";
      vAnzeige = Util.formatString(this.getEreignisBezeichnung(), 33)
               + Util.formatString(" am " +this.getEreignisDatum(), 16)
               + "  "
               + Util.formatString(this.getEreignisBemerkung() +plh, 54)
               + "     "
               + Util.formatString(vTeilnahme,6)
               + Util.formatString(vFreitext,32)
               ;
      //
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
   * Alle Ereignisse und entsprechende Teilnahme des Users aus Datenbank 
   * selektieren und als Arraylist bereitstellen
   * QUERY: Alle Teilnahmen-Ereignisse Datensätze des Users
   *   und  alle übrigbleibenden Ereignisse ohne Teilnahme Rows des Users
   * (Outer Join hierbei nicht möglich da sonst auch übrigbleibende Ereignisse
   *  wegfallen bei welchen andere User teilnehmen) 
   *  Als Parameter wird pAktuell als boolscher Wert erwartet
   *    TRUE : Nur Ereignisse ab SYSDATE werden ermittelt
   *    FALSE : Alle Ereignisse werden ermittelt (auch vergangene)
   * ------------------------------------------------------------------------
   */
  public ArrayList<TeilnehmerEreignis> alleLesenProLoginId(Boolean pAktuell)
  {
    System.out.println("alleLesenProLoginId: returns ArrayList<TeilnehmerEreignis>");
    String vDatum = "";
    //
    if (pAktuell)
    {
      // SYSDATE Objekt erstellen
      DatenbankSystemDatum tHeute = new DatenbankSystemDatum();
      vDatum = tHeute.getSysdate();
      // Löschen temporäre Variable und damit auch das Objekt!
      tHeute = null;
    }
    else
    {
      // Datum von "Anfang" an
      vDatum = "01.01.1000";
    }
    //---------------------------------------------------------------------
    // Leere ArrayList anlegen
    ArrayList<TeilnehmerEreignis> tListe = new ArrayList<TeilnehmerEreignis>();
    try
    {
      // sql befehl als string zusammenbauen
      String tString = " select e.ereignis_id"
                      +"      , e.bezeichnung as ereignis_bezeichnung"
                      +"      , DATE_FORMAT(e.datum,'%d.%m.%Y') as datum"
                      +"      , e.datum as datum_unformatiert"
                      +"      , e.bemerkung"
                      +"      , e.person_id as organisator_person_id"
                      +"      , 1 as teilnehmer_erkennung"
                      +"      , t.teilnehmer_id"
                      +"      , t.status"
                      +"      , t.freitext"
                      +"      , t.ereignis_id"
                      +"      , t.person_id as teilnehmer_person_id"
                      +" from ereignis as e"
                      +" inner join teilnehmer as t using (ereignis_id)"
                      +" where t.person_id = ?"
                      +" and e.datum >= STR_TO_DATE(?,'%d.%m.%Y')"
                      +"                      " 
                      +" UNION                "
                      +"                      "
                      +" select e.ereignis_id"
                      +"      , e.bezeichnung as ereignis_bezeichnung"
                      +"      , DATE_FORMAT(e.datum,'%d.%m.%Y') as datum"
                      +"      , e.datum as datum_unformatiert"
                      +"      , e.bemerkung"
                      +"      , e.person_id as organisator_person_id"
                      +"      , 0 as teilnehmer_erkennung"
                      +"      , null"
                      +"      , null"
                      +"      , null"
                      +"      , null"
                      +"      , null"
                      +" from ereignis as e"
                      +" where not exists (select 1"
                      +"                   from teilnehmer "
                      +"                   where ereignis_id = e.ereignis_id "
                      +"                   and person_id = ?)"
                      +" and e.datum >= STR_TO_DATE(?,'%d.%m.%Y')"
                      +" order by datum_unformatiert desc"
                      ;
      System.out.println(tString);
      //
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);
      //
      
      //
      tStatement.setInt(1, Person.getLoginId());
      tStatement.setString(2, vDatum);
      tStatement.setInt(3, Person.getLoginId());
      tStatement.setString(4, vDatum);
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Tabelle.
      ResultSet tErgebnis = tStatement.executeQuery();
      //
      // Aus jeder Zeile ein TeilnehmerEreignis-Objekt erzeugen.
      // TeilnehmerEreignis-Objekt in ArrayList einsetzen.
      // ==> Hierbei kann es sich um folgende Varianten handeln:
      // a) Ereignis mit Teilnahme (ja oder nein)
      // b) Nur Ereignis (noch ohne Teilnahme) - dbseitig ein Outer Join!!!
      //
      // Schleife über ResultSet - nur sequentielles Lesen möglich!
      while (tErgebnis.next())
      {        
        // 
        System.out.println("  DB Zugriff: " +tErgebnis.getString("ereignis_bezeichnung"));
        System.out.println("     Teiln. : " +tErgebnis.getString("status"));
        TeilnehmerEreignis tTeilnehmerEreignis = new TeilnehmerEreignis();
        tTeilnehmerEreignis.setEreignisBezeichnung(tErgebnis.getString("ereignis_bezeichnung"));
        tTeilnehmerEreignis.setEreignisDatum(tErgebnis.getString("datum"));
        tTeilnehmerEreignis.setEreignisId(tErgebnis.getInt("ereignis_id"));
        tTeilnehmerEreignis.setEreignisBemerkung(tErgebnis.getString("bemerkung"));
        tTeilnehmerEreignis.setEreignisOrganisatorPersonId(tErgebnis.getInt("organisator_person_id"));
        tTeilnehmerEreignis.setTeilnehmerErkennung(tErgebnis.getInt("teilnehmer_erkennung"));
        // Wenn nun Person auch als Teilnehmer vorhanden, dann auch in 
        // TeilnehmerEreignis-Objekt abfüllen...
        if (tTeilnehmerEreignis.getTeilnehmerErkennung().equals(1))
        {                            
          System.out.println(this.getEreignisBezeichnung() +" ==> Mit Teilnahme");
          tTeilnehmerEreignis.setTeilnehmerPersonId(tErgebnis.getInt("teilnehmer_person_id"));
          tTeilnehmerEreignis.setTeilnehmerId(tErgebnis.getInt("teilnehmer_id"));
          tTeilnehmerEreignis.setTeilnehmerFreitext(tErgebnis.getString("freitext"));
          tTeilnehmerEreignis.setTeilnehmerStatus(tErgebnis.getString("status"));
        }
        else
          System.out.println(this.getEreignisBezeichnung() +" ==> Ohne Teilnahme");
        // in ArrayListe füllen
        tListe.add(tTeilnehmerEreignis);      
      }     
      // Ressourcen freigeben
      System.out.println("Ende DB Zugriff");
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("TeilnehmerEreignis.alleLesenProPerson: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
    return tListe;    
  }

  /**
   * ------------------------------------------------------------------------
   * teilnehmen
   * ------------------------------------------------------------------------
   */
  public void teilnehmen()
  {
    this.setTeilnehmerStatus("JA");
    /*
    System.out.println("==>" +this.getEreignisBezeichnung());
    System.out.println("==>" +this.getteilnehmerStatus());
    System.out.println("==>" +this.getEreignisId());
    System.out.println("==>" +this.getTeilnehmerId());
    */
    speichern();
  }

  /**
   * ------------------------------------------------------------------------
   * nichtTeilnehmen
   * ------------------------------------------------------------------------
   */
  public void nichtTeilnehmen()
  {
    this.setTeilnehmerStatus("NEIN");
    speichern();    
  }

  /**
   * ------------------------------------------------------------------------
   * loeschenTeilnehmen
   * ------------------------------------------------------------------------
   */
  public void loeschenTeilnehmen()
  {
    loeschen();    
  }  
  
  /**
   * ------------------------------------------------------------------------
   * Änderungen des eigenen Personen Objektes in der Datenbank aktualisieren
   * ------------------------------------------------------------------------
   */
  private void speichern()  
  {
    // ändern oder einfügen....
    // check ob zu diesem TeilnehmerEreignis bereits eine Teilnahme vorhanden
    // oder ob nur ein einfaches Ereignis
    if (this.getTeilnehmerErkennung().equals(0))
      einfuegen();
    else
      aendern();
  }
    
  /**
   * ------------------------------------------------------------------------
   * aendern 
   * ------------------------------------------------------------------------
   */
  private void aendern()
  {
    try
    {    
      // sql befehl als string zusammenbauen
      String tString = "replace into teilnehmer"
                     + " (ereignis_id, person_id, status, freitext,teilnehmer_id)"
                     + " values(?,?,?,?,?)";
       //
      System.out.println("----------------------------");
      System.out.println(tString);   
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);      
      // jetzt aber noch platzhalter variable füllen
      tStatement.setInt(1, this.getEreignisId());
      tStatement.setInt(2, Person.getLoginId());
      tStatement.setString(3, this.getTeilnehmerStatus());
      tStatement.setString(4, this.getTeilnehmerFreitext());
      tStatement.setInt(5, this.getTeilnehmerId());
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Integer Zahl!
      Integer tErgebnis = tStatement.executeUpdate();
      System.out.println("Update in DB (Teilnehmer): " +tErgebnis +" Rows");
      //
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("TeilnehmerEreignis.aendern: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
  }   

  /**
   * ------------------------------------------------------------------------
   * einfuegen 
   * ------------------------------------------------------------------------
   */
  private void einfuegen()
  {
    try
    {    
      // sql befehl als string zusammenbauen
      String tString = "insert into teilnehmer"
                     + " (ereignis_id, person_id, status, freitext)"
                     + " values(?,?,?,?)";
       //
      System.out.println("----------------------------");
      System.out.println(tString);   
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);      
      // jetzt aber noch platzhalter variable füllen
      tStatement.setInt(1, this.getEreignisId());
      tStatement.setInt(2, Person.getLoginId());
      tStatement.setString(3, this.getTeilnehmerStatus());
      tStatement.setString(4, this.getTeilnehmerFreitext());
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Integer Zahl!
      Integer tErgebnis = tStatement.executeUpdate();
      System.out.println("Insert in DB (Teilnehmer): " +tErgebnis +" Rows");
      //
      // Ressourcen freigeben
      tStatement.close();
      //
      // jetzt müssten wir eigentlich noch die von der DB erhöhte teilnehmerId
      // ermitteln ... nun denn - ist hier nicht nötig da die Objekte allesamt
      // sowieso wieder mit listeFuellen() von der DB gelesen werden. 
      // Auch ein Löschen eines TeilnehmerEreignis Objekts ist nicht möglich.
      // Also kann hier auf das Lesen der teilnehmerId verzichtet werden.
    }
    catch(Exception pException)
    {
      System.out.println("TeilnehmerEreignis.einfuegen: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
  }   

  /**
   * ------------------------------------------------------------------------
   * loeschen 
   * ------------------------------------------------------------------------
   */
  private void loeschen()
  {
    try
    {    
      // sql befehl als string zusammenbauen
      String tString = "delete from teilnehmer"
                     + " where teilnehmer_id = ?";
      //
      System.out.println("----------------------------");
      System.out.println(tString);   
      // Statement auf Basis der Connection erzeugen - mit sql befehl
      // Java Ordner hl-seo: 7-38
      PreparedStatement tStatement = this.getDbConnection().prepareStatement(tString);      
      // jetzt aber noch platzhalter variable füllen
      tStatement.setInt(1, this.getTeilnehmerId());
      //
      // Statement ausführen - an die db senden und auf ergebnis warten
      // Ergebnis ist eine Integer Zahl!
      Integer tErgebnis = tStatement.executeUpdate();
      System.out.println("Delete in DB (Teilnehmer): " +tErgebnis +" Rows");
      //
      // Ressourcen freigeben
      tStatement.close();
    }
    catch(Exception pException)
    {
      System.out.println("TeilnehmerEreignis.loeschen: Fehler: " + pException);
      pException.printStackTrace();
      System.exit(-99);      
    }
  }   
  
  
} // end Class
