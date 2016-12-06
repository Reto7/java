package Fach_4_Datenbanken;

import java.sql.*;

/**
 * Created by rk on 06.12.16.
 */
public class BasisJdbcTest {
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

        ResultSet resultset;

        // STATEMENT
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        resultset = statement.executeQuery("SELECT land_name FROM laender where land_kuerzel = 'CH' ");
        while (resultset.next()){
            System.out.println("Row selektiert: " +resultset.getString("land_name"));
        }
        resultset.close();
        System.out.println("----------------------------------------");

        // STATEMENT
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        resultset = statement.executeQuery("SELECT count(*) as anzahl FROM laender");
        while (resultset.next()){
            System.out.println("Anzahl Laender: " +resultset.getString("anzahl"));
        }
        resultset.close();
        System.out.println("----------------------------------------");


        // PREPARED STATEMENT
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        String landInput = "CH";
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT land_name FROM laender where land_kuerzel = ? ");
        // Erstes Fragezeichen durch CH ersetzten!
        preparedStatement.setString(1, landInput);
        resultset = preparedStatement.executeQuery();
        while (resultset.next()){
            System.out.println("Row selektiert: " +resultset.getString("land_name"));
        }
        resultset.close();
        System.out.println("----------------------------------------");


        // STATEMENT
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        int x = statement.executeUpdate("DELETE FROM laender where land_kuerzel = 'DE'");
        System.out.println("Deleted: " +x);


        // alles wieder sauber schliessen
        statement.close();
        connection.close();

    }
}
