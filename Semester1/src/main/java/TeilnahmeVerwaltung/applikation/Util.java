package applikation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util
{
  /**
   * ---------------------------------------------------------------------
   * Pruefen einen Strings auf konformit�t mit dem in dieser Applikation
   * vereinbarten Datumformats dd.mm.yyyy
   * Die regul�re Expression funktioniert aber noch nicht ganz korrekt...
   * ---------------------------------------------------------------------
   */
  public static Boolean pruefenDatumFormat(String pString)
  {
    Boolean testFlag;
    try
    {
   // F�r einen Punkt m�sste nach \. gesucht werden. Ergibt aber Java Fehler ?! 
      Pattern p = Pattern.compile("[0-3][0-9].[0-1][0-9].[1-2][0|9][0-9][0-9]");
      Matcher m = p.matcher(pString);
      testFlag = m.matches();
      if (testFlag)
        System.out.println("Datumformat: Match !");
      else
        System.out.println("Datumformat: Kein Match");
    }
    catch(Exception pException)
    {
      System.out.println("Datumformat: Fehler bei " +pString +" ==> " + pException);
      pException.printStackTrace();
      testFlag = false;
    }
    return testFlag;    
  }
  
  /**
   * ---------------------------------------------------------------------
   * formatString Methode um einen String (pString) auf eine feste 
   * L�nge (pLaenge) zu setzen.
   * Wenn der String k�rzer ist als die gew�nschte L�nge 
   * ==> Auff�llen mit Blanks
   * Wenn der String l�nger ist als die gew�nschte L�nge
   * ==> Abschneiden
   * ---------------------------------------------------------------------
   */
  public static String formatString(String pString, Integer pLaenge)
  {

  Integer i,vDiff,vStringLaenge;
    String vAusgabe = new String();
    vStringLaenge = pString.length();
    
    if (vStringLaenge == pLaenge)
      vAusgabe = pString;
    
    if (vStringLaenge > pLaenge)
    {
      vAusgabe=pString.substring(0,pLaenge);
    }
    
    if (vStringLaenge < pLaenge)
    {
      vDiff = pLaenge - vStringLaenge;
      vAusgabe = pString;
      for (i=0; i<vDiff; i++)
      {
        vAusgabe = vAusgabe.concat(" ");
      }
    }
    return vAusgabe;
  }

    
  
} // End Class

