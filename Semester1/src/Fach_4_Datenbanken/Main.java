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
        statement.execute(" CREATE TABLE laender (land_name varchar(100))");
        // Insert-Anweisung ausführen
        statement.executeUpdate(" INSERT INTO laender VALUES('Deutschland')");
        statement.executeUpdate(" INSERT INTO laender VALUES('Schweiz')");
        // Select ausführen
        ResultSet resultset = statement.executeQuery("SELECT land_name FROM laender");
        // Resultat!
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        while (resultset.next()){
            System.out.println(resultset.getString("land_name"));
        }
        // Statement und Verbindung schließen
        statement.close();
        connection.close();
        System.out.println("...fertig");
    }
}
