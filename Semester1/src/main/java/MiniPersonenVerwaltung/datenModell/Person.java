package MiniPersonenVerwaltung.datenModell;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.*;

public class Person
{
  // Klassen-Variable
    
  // Instanz-Variable
  private Integer oid;
  private String name;
  private Integer geburt;
  private Double gehalt;

  // Konstruktor
  public Person ()
  {
    this.oid = null; // oid wird beim 1. speichern (einfuegen) gesetzt
    this.name = null;
    this.gehalt= null;
  }

  // ***************************************************************************
  // set- und get-Operationen
  // ***************************************************************************
  public Integer getGeburt()
  {
    return this.geburt;
  }
  public void setGeburt(Integer pGeburt)
  {
    this.geburt = pGeburt;
  }
  public Double getGehalt()
  {
    return this.gehalt;
  }
  public void setGehalt(Double pGehalt)
  {
    this.gehalt = pGehalt;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String pName)
  {
    this.name = pName;
  }
  public Integer getOid()
  {
    return this.oid;
  }
  public void setOid(Integer pOid)
  {
    this.oid = pOid;
  }
 
  // ---------------------------------------------------------------------------
  public String toString()
  {
    String tString;

    tString = "OID=" + this.oid + ",  " + this.name;
    return tString;
  }


  // ***************************************************************************
  // Datenbank-Operationen
  // ***************************************************************************

  public static Connection getDbConnection()
  {
    return DbManager.getDbConnection();
  }

  // ---------------------------------------------------------------------------
  public void save()
  {
    // beim Speichern wird die oid geprueft
    // 0  bedeutet, Objekt ist noch nicht gespeichert worden --> insert
    // >0 bedeutet, Objekt ist bereits in der Tabelle vorhanden --> update

    if (this.getOid() == null)
    {
    	this.insert();
    }
    else if (this.getOid() <= 0)
   	{
        this.insert();   		
    }
    else
    {
    	this.update();
    }
  }

  // ---------------------------------------------------------------------------
  public void insert()
  {
    String tSql;
    PreparedStatement tStatement;
    int tResult;

    // Neue oid vor dem ersten Speichern festlegen
    this.oid = this.getNewOid();

    tSql = "INSERT INTO person (oid, name, geburt, gehalt) VALUES (?, ?, ?, ?)";

    try
    {
      // SQL-Befehl aufbereiten Folie 12, Beispiel Folie 45...
      tStatement = getDbConnection().prepareStatement(tSql);
      tStatement.setInt(1,this.getOid());
      tStatement.setString(2,this.getName());
      tStatement.setInt(3,this.getGeburt());
      tStatement.setDouble(4,this.getGehalt());
      
      tResult = tStatement.executeUpdate();
      System.out.println("Person.einfuegen: " + tResult);
    }
    catch (Exception pException)
    {
      pException.printStackTrace();
      System.exit(0);
    }
  }

  // ---------------------------------------------------------------------------
  public void update()
  {
    String tSql;
    PreparedStatement tStatement;
    int tResult;

    tSql = "UPDATE person SET name=?, geburt=?, gehalt=? WHERE oid=?";

    try
    {
      // SQL-Befehl aufbereiten Folie 12, Beispiel Folie 48...
      tStatement = getDbConnection().prepareStatement(tSql);
      tStatement.setString(1,this.getName());
      tStatement.setInt(2,this.getGeburt());
      tStatement.setDouble(3,this.getGehalt());
      tStatement.setInt(4,this.getOid());

      tResult = tStatement.executeUpdate();
      System.out.println("Person.aendern: " + tResult);
    }
    catch (Exception pException)
    {
      pException.printStackTrace();
      System.exit(0);
    }

  }
  // ---------------------------------------------------------------------------
  public void delete()
  {
    String tSql;
    PreparedStatement tStatement;
    int tResult;

    tSql = "DELETE FROM person WHERE oid=?";

    try
    {
      // SQL-Befehl aufbereiten Folie 12, Beispiel Folie 50...
      tStatement = getDbConnection().prepareStatement(tSql);
      tStatement.setInt(1,this.getOid());

      tResult = tStatement.executeUpdate();
      System.out.println("Person.loeschen: " + tResult);
    }
    catch (Exception pException)
    {
      pException.printStackTrace();
      System.exit(0);
    }
  }

  // ---------------------------------------------------------------------------
  public ArrayList<Person> search()
  {
    String tSql;
    String tWhereString = " WHERE ";
    Integer tWhereFlag = 0;
    Statement tStatement;
    ResultSet tResult;
    ArrayList<Person> tArrayList = new ArrayList<Person>();

    /**
     * Zusammenbau des WhereStrings. Hier fehlen mir gute Ideen
     */
    
    if (this.oid instanceof Integer)
    {
    	tWhereFlag++;
    	tWhereString += "oid=" + this.oid;    	
    }
    
    if (this.name instanceof String)
    {
    	if (tWhereFlag>0)
    	{
    		tWhereString += " AND ";
    	}
    	tWhereFlag++;
    	
    	tWhereString += "name LIKE '" + this.name + "'";
    }  
    
    if (this.geburt instanceof Integer)
    {
    	if (tWhereFlag>0)
    	{
    		tWhereString += " AND ";
    	}
    	tWhereFlag++;
    	
    	tWhereString += "geburt=" + this.geburt;
    }  
    
    if (this.gehalt instanceof Double)
    {
    	if (tWhereFlag>0)
    	{
    		tWhereString += " AND ";
    	}
    	tWhereFlag++;
    	
    	tWhereString += "gehalt=" + this.gehalt;
    }  
    
    
    
    tSql = "SELECT * FROM person ";
    
    if (tWhereFlag>0)
    {
    	tSql += tWhereString;
    }
    
    System.out.println("Person.search tSql=" + tSql);
    
    try
    {
      // SQL-Befehl aufbereiten Folie 12, Beispiel Folie 40...
      tStatement = getDbConnection().createStatement();
      tResult = tStatement.executeQuery(tSql);

      while (tResult.next())
      {
        // neues Personen-Objekt
        Person tPerson = new Person();
        tPerson.setOid(tResult.getInt("oid"));
        tPerson.setName(tResult.getString("name"));
        tPerson.setGeburt(tResult.getInt("geburt"));
        tPerson.setGehalt(tResult.getDouble("gehalt"));

        // Objekt in Vector einsetzen
        tArrayList.add(tPerson);
      }
    }
    catch (Exception pException)
    {
      pException.printStackTrace();
      System.exit(0);
    }
    return tArrayList;
  }

  // ---------------------------------------------------------------------------
  public int getNewOid()
  {
    String tSql;
    PreparedStatement tStatement;
    ResultSet tResult;
    Integer tNeueOid = 1;

    tSql = "SELECT MAX(oid) AS maximum FROM person";

    try
    {
      // SQL-Befehl aufbereiten Folie 12, Beispiel Folie 40...
      tStatement = getDbConnection().prepareStatement(tSql);
      tResult = tStatement.executeQuery();  // executeQuery liefert immer ResultSet

      tResult.next();
      tNeueOid = tResult.getInt("maximum");
      tNeueOid = tNeueOid + 1;
    }
    catch (Exception pException)
    {
      pException.printStackTrace();
      System.exit(0);
    }
    System.out.println("Person.getNeueOid: " + tNeueOid);
    return tNeueOid;
  }

  // ---------------------------------------------------------------------------
  public Person searchUnique()
  {
	Collection<Person> tCollection;
	
	/*
	 * oid muss gesetzt sein
	 */
	if (this.oid instanceof Integer)
	{
		tCollection = this.search();
		
		if (!tCollection.isEmpty())
		{
			return tCollection.iterator().next();
		}
	}
    return null;
  }


  //--------------------------------------------------------------------------
  public static void tableCreate()
  {
	  String tSql="";
      PreparedStatement tStatement;
	  int tResult;
			  
	  if (DbManager.getDbSelektion() == "Access")
	  {
		    tSql = "CREATE TABLE person ([oid] INTEGER, [name] TEXT(30), " 
	    		+ "[geburt] integer, [gehalt] double";
	  }
	  else if(DbManager.getDbSelektion() == "mySql")
	  {
		    tSql = "CREATE TABLE person (oid INTEGER, name VARCHAR(30), " 
	    		+ "geburt INTEGER(4), gehalt DECIMAL(9,2))";
	  }
      else if(DbManager.getDbSelektion() == "postgres")
      {
          tSql = "CREATE TABLE person (oid INTEGER, name VARCHAR(30), "
                  + "geburt INTEGER, gehalt DECIMAL(9,2))";
      }
	  else
	  { 
		  System.out.println("Person.tabelleErstellen: dbSelektion("
				  		+DbManager.getDbSelektion()+ ") ist falsch");
	  }
	
	  System.out.println("tabelleAnlegen (" + DbManager.getDbSelektion() +") SQL: "+ tSql);
				    try
				    {
				      // SQL-Befehl aufbereiten Folie 12, Beispiel Folie 50...
				      tStatement = getDbConnection().prepareStatement(tSql);
		
				      tResult = tStatement.executeUpdate();
				      System.out.println("Person.createTable: " + tResult);
				    }
				    catch (Exception pException)
				    {
				      pException.printStackTrace();
				    }					    
  }
	//--------------------------------------------------------------------------
 public static void tableDrop()
 {
	String tSql="";
	
	PreparedStatement tStatement;
	int tResult;
			
		    tSql = "DROP TABLE person";
				    try
				    {
				      // SQL-Befehl aufbereiten Folie 12, Beispiel Folie 50...
				      tStatement = getDbConnection().prepareStatement(tSql);
		
				      tResult = tStatement.executeUpdate();
				      System.out.println("Person.tabelleLoeschen: " + tResult);
				    }
				    catch (Exception pException)
			    {
			      pException.printStackTrace();
			    }
	}

//--------------------------------------------------------------------------
public static void tableInit()
{
	Person tPerson;
	
	tPerson = new Person();
	tPerson.setName("Donald");
	tPerson.setGeburt(1970);
	tPerson.setGehalt(1000.0);
	tPerson.save();

	tPerson = new Person();
	tPerson.setName("Daisy");
	tPerson.setGeburt(1972);
	tPerson.setGehalt(1200.0);
	tPerson.save();

	tPerson = new Person();
	tPerson.setName("Trick");
	tPerson.setGeburt(1990);
	tPerson.setGehalt(150.0);
	tPerson.save();
}
  
} // Ende Klasse

