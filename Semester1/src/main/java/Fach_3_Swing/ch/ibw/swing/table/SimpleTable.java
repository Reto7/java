package Fach_3_Swing.ch.ibw.swing.table;


import javax.swing.*;

public class SimpleTable
{
    public static void main( String[] args )
    {
        String[][] rowData = {
                { "Japan", "245" }, { "USA", "240" }, { "Italien", "220" },
                { "Spanien", "217" }, {"Türkei", "215"} ,{ "England", "214" },
                { "Frankreich", "190" }, {"Griechenland", "185" },
                { "Deutschland", "180" }, {"Portugal", "170" }
        };

        String[] columnNames =  {
                "Land", "Durchschnittliche Fernsehdauer pro Tag in Minuten"
        };

        JFrame f = new JFrame();
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        JTable table = new JTable( rowData, columnNames );
        // Damit die Tabelle Schrollbars bekommt (wenn man window kleiner macht)
        f.add( new JScrollPane( table ) );

        f.pack();
        f.setVisible( true );
    }
}