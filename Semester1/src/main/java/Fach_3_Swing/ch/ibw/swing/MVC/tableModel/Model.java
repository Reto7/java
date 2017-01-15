package Fach_3_Swing.ch.ibw.swing.MVC.tableModel;

import javax.swing.table.DefaultTableModel;

/**
 * Created by user on 26.12.2016.
 */
public class Model extends DefaultTableModel {

    public Model() {
        super(Constants.DATA, Constants.TABLE_HEADER);
    }

}