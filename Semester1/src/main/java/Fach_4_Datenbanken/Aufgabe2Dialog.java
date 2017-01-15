package Fach_4_Datenbanken;

/**
 * Created by rk on 06.12.16.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Aufgabe2Dialog extends JDialog {

    private static final long serialVersionUID = 1L;
    JPanel contents;
    JPanel topPanel;
    JPanel centerPanel;
    JLabel urlLabel;
    JTextField urlTextField;
    JLabel userLabel;
    JTextField userTextField;
    JLabel passwordLabel;
    JPasswordField passwordTextField;
    JLabel queryLabel;
    JTextArea queryTextArea;
    JButton executeButton;
    JTextArea resultArea;

    public Aufgabe2Dialog() {
        super((JDialog) null, "QueryTool");
        contents = new JPanel();
        contents.setLayout(new BorderLayout());
        contents.setPreferredSize(new Dimension(700,400));

        topPanel = new JPanel();
        GridBagLayout topPanelLayout = new GridBagLayout();
        topPanel.setLayout(topPanelLayout);
        contents.add(topPanel, BorderLayout.PAGE_START);

        urlLabel = new JLabel("URL");
        GridBagConstraints urlLabelConstraint = new GridBagConstraints();
        urlLabelConstraint.gridx = 0;
        urlLabelConstraint.gridy = 0;
        urlLabelConstraint.anchor = GridBagConstraints.WEST;
        topPanel.add(urlLabel, urlLabelConstraint);

        urlTextField = new JTextField("jdbc:postgresql://localhost/byceco");
        GridBagConstraints urlTextFieldConstraint = new GridBagConstraints();
        urlTextFieldConstraint.gridx = 1;
        urlTextFieldConstraint.gridy = 0;
        urlTextFieldConstraint.fill = GridBagConstraints.HORIZONTAL;
        urlTextFieldConstraint.weightx = 1;
        topPanel.add(urlTextField, urlTextFieldConstraint);

        userLabel = new JLabel("Benutzer");
        GridBagConstraints userLabelConstraint = new GridBagConstraints();
        userLabelConstraint.gridx = 0;
        userLabelConstraint.gridy = 1;
        userLabelConstraint.anchor = GridBagConstraints.WEST;
        topPanel.add(userLabel, userLabelConstraint);

        userTextField = new JTextField("postgres");
        GridBagConstraints userTextFieldConstraint = new GridBagConstraints();
        userTextFieldConstraint.gridx = 1;
        userTextFieldConstraint.gridy = 1;
        userTextFieldConstraint.fill = GridBagConstraints.HORIZONTAL;
        userTextFieldConstraint.weightx = 1;
        topPanel.add(userTextField, userTextFieldConstraint);

        passwordLabel = new JLabel("Passwort");
        GridBagConstraints passwordLabelConstraint = new GridBagConstraints();
        passwordLabelConstraint.gridx = 0;
        passwordLabelConstraint.gridy = 2;
        passwordLabelConstraint.anchor = GridBagConstraints.WEST;
        topPanel.add(passwordLabel, passwordLabelConstraint);

        passwordTextField = new JPasswordField("postgres");
        GridBagConstraints passwordTextFieldConstraint = new GridBagConstraints();
        passwordTextFieldConstraint.gridx = 1;
        passwordTextFieldConstraint.gridy = 2;
        passwordTextFieldConstraint.fill = GridBagConstraints.HORIZONTAL;
        passwordTextFieldConstraint.weightx = 1;
        topPanel.add(passwordTextField, passwordTextFieldConstraint);

        queryLabel = new JLabel("Abfrage");
        GridBagConstraints queryLabelConstraint = new GridBagConstraints();
        queryLabelConstraint.gridx = 0;
        queryLabelConstraint.gridy = 3;
        queryLabelConstraint.anchor = GridBagConstraints.WEST;
        topPanel.add(queryLabel, queryLabelConstraint);

        queryTextArea = new JTextArea("select * from artikel");
        queryTextArea.setRows(3);
        GridBagConstraints queryTextFieldConstraint = new GridBagConstraints();
        queryTextFieldConstraint.gridx = 1;
        queryTextFieldConstraint.gridy = 3;
        queryTextFieldConstraint.fill = GridBagConstraints.HORIZONTAL;
        queryTextFieldConstraint.weightx = 1;
        topPanel.add(queryTextArea, queryTextFieldConstraint);

        executeButton = new JButton("Ausführen");
        GridBagConstraints executeButtonConstraint = new GridBagConstraints();
        executeButtonConstraint.gridx = 1;
        executeButtonConstraint.gridy = 4;
        executeButtonConstraint.anchor = GridBagConstraints.EAST;
        topPanel.add(executeButton, executeButtonConstraint);
        executeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    execute();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        centerPanel = new JPanel();
        BorderLayout centerPanelLayout = new BorderLayout();
        centerPanel.setLayout(centerPanelLayout);
        contents.add(centerPanel, BorderLayout.CENTER);

        resultArea = new JTextArea("<Hier kommt das Resultat hin.>");
        centerPanel.add(resultArea, BorderLayout.CENTER);

        this.setContentPane(contents);

        this.pack();

    }

    private void execute() throws Exception {
        String row;
        String header;
        StringBuffer buf = new StringBuffer();

        //Treiber wird geladen und im DriverManager registriert.
        Class.forName("org.postgresql.Driver");

        //DB-Verbindung aufbauen:
        //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/byceco", "postgres","postgres");
        Connection connection = DriverManager.getConnection(urlTextField.getText(), userTextField.getText(), "postgres"); // TODO passwordTextField.getText());

        // Statische Abfrage (Statement) erstellen
        Statement statement = connection.createStatement();

        // STATEMENT
        // wie ein Cursor mit Zeiger. Steht Anfangs immer auf 1. Zeile. Falls next() false liefert, ist Zeiger am Schluss angekommen.
        ResultSet resultset = statement.executeQuery(queryTextArea.getText());
        // HEADER ZEILE
        for (int i =1; i<=resultset.getMetaData().getColumnCount(); i++){
            header =resultset.getMetaData().getColumnName(i).toUpperCase();
            System.out.print(header);
            System.out.println(" | ");
            // fuer Ausgabe:
            buf.append(header);
            buf.append(" | ");
        }
        buf.append("\n");
        // DATEN ZEILE
        while (resultset.next()){
            for (int i =1; i<=resultset.getMetaData().getColumnCount(); i++){
                row = resultset.getString(i);
                System.out.println(row);
                // fuer Ausgabe:
                buf.append(row);
                buf.append(" | ");

            }
            buf.append("\n");


        }
        resultset.close();
        //System.out.println("----------------------------------------");




        resultArea.setText(buf.toString());
    }


}