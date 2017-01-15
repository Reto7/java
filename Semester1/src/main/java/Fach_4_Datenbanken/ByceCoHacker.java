package Fach_4_Datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by rk on 06.12.16.
 */
public class ByceCoHacker {
    public static void main(String[] args) throws Exception {

        //Treiber wird geladen und im DriverManager registriert.
        Class.forName("org.postgresql.Driver");

        //DB-Verbindung aufbauen:
        //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/byceco", "postgres","postgres");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/byceco", "postgres","postgres");

        // Statische Abfrage (Statement) erstellen
        Statement statement = connection.createStatement();

        // Resultset Objekt bereitstellen
        ResultSet resultset;
        PreparedStatement preparedStatement;

        /*
        // PREPARED STATEMENT
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        preparedStatement = connection.prepareStatement("SELECT * FROM artikel");
        // Erstes Fragezeichen durch CH ersetzten!
        // preparedStatement.setString(1, landInput);
        resultset = preparedStatement.executeQuery();
        while (resultset.next()){
            System.out.println("Row selektiert: " +resultset.getInt("tnr") +" | "
                    +resultset.getString("bezeichnung")  +" | "
                    +resultset.getString("artikel_typ") +" | "
                    +resultset.getInt("verkaufspreis") +" | "
                    +resultset.getInt("jahresumsatz") +" | "
                    +resultset.getDate("zeitstempel")
            );
        }
        resultset.close();
        System.out.println("----------------------------------------");
        */

        // SQL INJECTION
        String hacker = "x' OR 1=1; --";
        //SELECT * FROM artikel where bezeichnung = 'x'' OR 1=1; --' and tnr > 60

        // PREPARED STATEMENT
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        preparedStatement = connection.prepareStatement("SELECT * FROM artikel where bezeichnung = ? and tnr > 60");
        System.out.println(preparedStatement.toString());
        // Erstes Fragezeichen durch CH ersetzten!
        preparedStatement.setString(1, hacker);
        System.out.println(preparedStatement.toString());
        resultset = preparedStatement.executeQuery();
        while (resultset.next()){
            System.out.println("Row selektiert: "
                    +resultset.getInt("tnr") +" | "
                    +resultset.getString("bezeichnung")  +" | "
                    +resultset.getString("artikel_typ") +" | "
                    +resultset.getInt("verkaufspreis") +" | "
                    +resultset.getInt("jahresumsatz") +" | "
                    +resultset.getDate("zeitstempel")
            );
        }
        resultset.close();
        System.out.println("----------------------------------------");



        // alles wieder sauber schliessen
        statement.close();
        connection.close();

    }
}
