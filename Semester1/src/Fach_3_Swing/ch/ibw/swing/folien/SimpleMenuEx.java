package ch.ibw.swing.folien;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SimpleMenuEx extends JFrame {

    public SimpleMenuEx()
    {

        initUI();
    }

    private void initUI()
    {

        createMenuBar();

        setTitle("Simple menu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar()
    {

        JMenuBar menubar = new JMenuBar();


        JMenu file = new JMenu("Datei");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Beenden");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);
    }

    public static void main(String[] args)
    {
        SimpleMenuEx ex = new SimpleMenuEx();
        ex.setVisible(true);
    }
}
