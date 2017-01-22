package Fach_4_Datenbanken.modelMitGui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by rk on 06.12.16.
 */
public class AbteilungController {

    public AbteilungController() {
        try {
            readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ArrayList<AbteilungTO> abteilungsListe = new ArrayList<AbteilungTO>();

    public ArrayList<AbteilungTO> getAbteilungsListe() {
        return abteilungsListe;
    }
    public void setAbteilungsListe(ArrayList<AbteilungTO> abteilungsListe) {
        this.abteilungsListe = abteilungsListe;
    }

    public void readAll() throws Exception {

        AbteilungTO abteilungTO = null;

        //Treiber wird geladen und im DriverManager registriert.
        Class.forName("org.postgresql.Driver");

        //DB-Verbindung aufbauen:
        //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/byceco", "postgres","postgres");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/byceco", "postgres","postgres");

        // Statische Abfrage (Statement) erstellen
        Statement statement = connection.createStatement();

        ResultSet resultset;

        // STATEMENT
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        resultset = statement.executeQuery("SELECT * FROM abteilungen where 1=1 ");
        while (resultset.next()){
            //System.out.println("Row selektiert: " +resultset.getString("abt_nr"));
            abteilungTO = new AbteilungTO();
            abteilungTO.setAbt_nr(String.valueOf(resultset.getInt("abt_nr")));
            abteilungTO.setLeiter(resultset.getString("leiter"));
            abteilungTO.setName(resultset.getString("name"));
            abteilungTO.setOrt(resultset.getString("ort"));
            System.out.println(abteilungTO);
            abteilungsListe.add(abteilungTO);
        }
        resultset.close();
        System.out.println("----------------------------------------");

        // alles wieder sauber schliessen
        statement.close();
        connection.close();

    }
}
