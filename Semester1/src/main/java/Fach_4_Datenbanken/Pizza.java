package Fach_4_Datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by Reto Kaufmann
 */
public class Pizza {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Benutzername des Kunden eingeben: ");
        String benutzername = scanner.next();

        System.out.print("Bitte Jahr eingeben: ");
        int jahr = scanner.nextInt();

        System.out.print("Bitte Monat eingeben: ");
        int monat = scanner. nextInt();

        scanner.close();



        //Treiber wird geladen und im DriverManager registriert.
        Class.forName("org.postgresql.Driver");

        //DB-Verbindung aufbauen:
        //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/byceco", "postgres","postgres");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/pizza_db", "postgres","postgres");


        // PREPARED STATEMENT
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        String landInput = "CH";
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT b.benutzername, b.bestellNr, SUM(bp.anzahl * p.preis) AS gesamtbetrag\n" +
                "FROM bestellung b JOIN bestellposition bp ON b.bestellNr = bp.bestellNr \n" +
                "  JOIN pizza p ON bp.pizza = p.name \n" +
                "WHERE b.benutzername = ? \n" +
                "  AND EXTRACT(YEAR FROM b.zeitpunkt) = ? \n" +
                "  AND EXTRACT(MONTH FROM b.zeitpunkt) = ? \n" +
                "GROUP BY b.benutzername, b.bestellNr");
        // Erstes Fragezeichen durch CH ersetzten!
        preparedStatement.setString(1, benutzername);
        preparedStatement.setInt(2, jahr);
        preparedStatement.setInt(3, monat);
        ResultSet resultset = preparedStatement.executeQuery();
        Boolean firstRow = true;
        Boolean hasResult = false;
        while (resultset.next()){
            hasResult = true;
            if (firstRow) {
                System.out.println("Monatsrechnung für " + resultset.getString("benutzername") + " für Monat " + monat + "." + jahr);
                firstRow = false;
            }
            System.out.println("   Bestellnr. " +resultset.getString("bestellNr") +": " +resultset.getString("gesamtbetrag") );
        }
        if (!hasResult){
            System.out.println("Keine Bestellungen in diesem Zeitraum");
        }
        resultset.close();
        System.out.println("----------------------------------------");

    }
}
