package Fach_3_Swing.ch.ibw.swing.uebungenJTable;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

import javax.swing.table.TableModel;

/**
 * Created by rk on 29.11.16.
 */
@Ignore
public class CSVJTableExampleTest {
    @Test
    public void parseCSVAndCreateTableModel() throws Exception {
        CSVJTableExample x = new CSVJTableExample();
        TableModel t = x.parseCSVAndCreateTableModel(new File("/home/rk/IntelliJ-Workspace/Semester1/src/Fach_3_Swing/ch/ibw/swing/uebungenJTable/daten.csv"));
    }

}