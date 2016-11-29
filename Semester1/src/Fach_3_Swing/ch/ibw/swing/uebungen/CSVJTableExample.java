package Fach_3_Swing.ch.ibw.swing.uebungen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.TableModel;


public class CSVJTableExample extends JFrame {

    private JTable table;
    private JButton btnAction;

    public CSVJTableExample()
    {
        super("CSVJTableExample");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnAction = new JButton("Dateiauswahl");
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e)
            {


            }
        });

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnAction, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(final String[] args)
    {
        new CSVJTableExample();
    }

    // File kennt nur die Informationen der Datei, kann weder oeffnen, noch lesen!
    private TableModel parseCSVAndCreateTableModel(final File file)
    {
        // Vector ist wie eine ArrayList
        // kann aber dagegen nicht auf ein einzelnes Element zugreifen
        final Vector v = new Vector();

        // Ein "Leser", stellt Lesefunktionen bereit, kann aber keine Datei oeffnen
        BufferedReader br = null;
        try {
            // Filereader oeffnet die Datei
            // der Zeiger steht auf oberster Position am Anfang
            br = new BufferedReader(new FileReader(file));

            // auf erster Zeile die Beschriftung lesen



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }

}
