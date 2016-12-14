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