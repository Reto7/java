package Fach_4_Datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by rk on 06.12.16.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        //Treiber wird geladen und im DriverManager registriert.
        Class.forName("org.postgresql.Driver");

        //DB-Verbindung aufbauen:
        Connection v_conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/byceco",
                "postgres","postgres");



        System.out.println("Hello World");
    }
}
