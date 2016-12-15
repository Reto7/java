package Fach_4_Datenbanken.modelMitGui;

/**
 * Created by rk on 14.12.16.
 */
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame {



    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        Vector columns = new Vector();
        columns.add("Name");
        columns.add("Ort");

        //Vector<AbteilungTO> abteilungsListe = new Vector<AbteilungTO>();
        //abteilungsListe = new Vector<AbteilungTO>();
        getAbteilungsListe();
        System.out.println("Abteilungsliste Anzahl: "+abteilungsListe.size());

        Vector vectorOfVector = new Vector(abteilungsListe.size());
        for (AbteilungTO a : abteilungsListe) {
            Vector vec = new Vector(2);   // create a vector for each row
            vec.add(a.getName());
            vec.add(a.getOrt());
            vectorOfVector.add(vec);
        }

        // JTable table = new JTable(data, columns);
        JTable table = new JTable(vectorOfVector, columns);
        */

        JTable table = new JTable();

        AbteilungController ac = new AbteilungController();

        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        model.setColumnIdentifiers(new String[]{"ort", "name"});
        for (AbteilungTO a : ac.getAbteilungsListe()) {
            model.addRow(new String[]{a.getOrt(), a.getName()});
        }

        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        pack();


    }

    public static void main(String arg[]) {
        new GUI().setVisible(true);
    }



}