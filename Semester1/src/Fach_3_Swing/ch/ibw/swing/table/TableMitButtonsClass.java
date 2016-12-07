package Fach_3_Swing.ch.ibw.swing.table;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableMitButtonsClass extends JFrame {
    final JTable table;
    final DefaultTableModel model;

    String[][] data1 = {new String[]{"Hund", "Pizza", "Rudern"},
            new String[]{"Pferd", "Hamburger", "Gewichtheben"},
            new String[]{"Fadenwurm", "Foie gras", "Fingerhakeln"}};
    String[] colNames1 = new String[]{"Viecher", "Haute Cuisine",
            "Kraftmeierei"};

    String[][] data2 = {new String[]{"BMW", "Schreiner", "Frau"},
            new String[]{"Ducati", "Metzger", "Mann"},
            new String[]{"Megola", "Stellmacher", "Zwitter"}};
    String[] colNames2 = new String[]{"Mopeds", "Berufe", "Geschlechter"};

    public TableMitButtonsClass()
    {
        model = new DefaultTableModel();
        table = new JTable(model);
        reload();
        JScrollPane sPane = new JScrollPane(table);

        getContentPane().add(sPane, BorderLayout.CENTER);
        JButton butt = new JButton("Neues TableModel");
        butt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                reload();
            }
        });
        getContentPane().add(butt, BorderLayout.SOUTH);
        this.setSize(600, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new TableMitButtonsClass();
    }

    private void reload()
    {
        if (table.getColumnCount() == 0
                || table.getColumnName(1).equals("Berufe")) {
            model.setDataVector(data1, colNames1);
        } else {
            model.setDataVector(data2, colNames2);
        }
        table.getColumn(table.getColumnName(1)).setCellRenderer(
                new JButtonRenderer());
        table.getColumn(table.getColumnName(1)).setCellEditor(
                new JButtonEditor());
    }
}

class JButtonRenderer implements TableCellRenderer {

    JButton button = new JButton();

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column)
    {
        table.setShowGrid(true);
        table.setGridColor(Color.LIGHT_GRAY);
        button.setText(value.toString());
        button.setToolTipText("Press " + value.toString());
        return button;
    }
}

class JButtonEditor extends AbstractCellEditor implements TableCellEditor {
    JButton button;
    String txt;

    public JButtonEditor()
    {
        super();
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Buttontext: " + button.getText());
            }
        });
    }

    public Object getCellEditorValue()
    {
        return null;
    }

    public boolean isCellEditable(EventObject anEvent)
    {
        return true;
    }

    public boolean shouldSelectCell(EventObject anEvent)
    {
        return false;
    }

    public boolean stopCellEditing()
    {
        return super.stopCellEditing();
    }

    public void cancelCellEditing()
    {
    }

    public void addCellEditorListener(CellEditorListener l)
    {
    }

    public void removeCellEditorListener(CellEditorListener l)
    {
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column)
    {
        txt = (value == null) ? "" : value.toString();
        button.setText(txt);
        return button;
    }
}