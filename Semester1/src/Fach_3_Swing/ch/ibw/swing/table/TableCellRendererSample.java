package Fach_3_Swing.ch.ibw.swing.table;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TableCellRendererSample {

    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[][] rowData = {
                {"Japan", "245"}, {"USA", "240"}, {"Italien", "220"},
                {"Spanien", "217"}, {"Türkei", "215"}, {"England", "214"},
                {"Frankreich", "190"}, {"Griechenland", "185"},
                {"Deutschland", "180"}, {"Portugal", "170"}
        };

        String[] columnNames = {
                "Land", "Durchschnittliche Fernsehdauer pro Tag in Minuten"
        };


        JTable table = new JTable(rowData, columnNames);
        // Damit die Tabelle Schrollbars bekommt
        f.add(new JScrollPane(table));

        int vColIndex = 0;
        TableColumn col = table.getColumnModel().getColumn(vColIndex);
        col.setCellRenderer(new MyTableCellRenderer());

        f.pack();
        f.setVisible(true);
    }
}

class MyTableCellRenderer extends JLabel implements TableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int rowIndex, int vColIndex)
    {
        setText(value.toString());
        setToolTipText((String) value);
        setForeground(isSelected ? Color.red : Color.black);
        return this;
    }
}