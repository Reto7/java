package Fach_3_Swing.ch.ibw.swing.table;


import javax.swing.*;

public class AbstractTableModelSample {
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.getContentPane().add( new JScrollPane( new JTable( new SquareTableModelSimple() ) ) );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.pack();
        f.setVisible( true );
    }
}
