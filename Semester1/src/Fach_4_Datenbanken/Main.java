package Fach_4_Datenbanken;

import java.sql.*;

/**
 * Created by rk on 06.12.16.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        //Treiber wird geladen und im DriverManager registriert.
        Class.forName("org.postgresql.Driver");

        //DB-Verbindung aufbauen:
        //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/byceco", "postgres","postgres");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/reto", "postgres","postgres");

        // Statische Abfrage (Statement) erstellen
        Statement statement = connection.createStatement();
        // CreateTable -Anweisung ausführen
        statement.execute(" DROP TABLE if exists laender");
        statement.execute(" CREATE TABLE laender (land_kuerzel varchar(2) PRIMARY KEY, land_name varchar(100))");
        // Insert-Anweisung ausführen
        statement.executeUpdate(" INSERT INTO laender (land_kuerzel, land_name) VALUES('DE','Deutschland')");
        statement.executeUpdate(" INSERT INTO laender (land_kuerzel, land_name) VALUES('CH','Schweiz')");
        // Select ausführen
        ResultSet resultset = statement.executeQuery("SELECT land_name FROM laender where land_kuerzel = 'CH' ");
        // Resultat!
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        while (resultset.next()){
            System.out.println("Row: " +resultset.getString("land_name"));
        }
        System.out.println("----------------------------------------");
        // Select ausführen
        resultset = statement.executeQuery("SELECT count(*) as anzahl FROM laender");
        // Resultat!
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        while (resultset.next()){
            System.out.println("Anzahl: " +resultset.getString("anzahl"));
        }
        System.out.println("----------------------------------------");
        // alles wieder sauber schliessen
        resultset.close();
        statement.close();
        connection.close();

    }
}
