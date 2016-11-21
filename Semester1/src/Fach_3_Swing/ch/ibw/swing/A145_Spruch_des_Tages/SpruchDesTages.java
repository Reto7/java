package Fach_3_Swing.ch.ibw.swing.A145_Spruch_des_Tages;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by user on 21.11.2016.
 */
public class SpruchDesTages extends JFrame {

    Container mainContainer;

    public SpruchDesTages() {    // Konstruktor

        mainContainer = getContentPane();             // Container bestimmen    TODO Frage Michele: ist ja nicht instanziert!?
        mainContainer.setLayout(new BorderLayout()); // Layout setzen

        JLabel headLabel = new JLabel("Spruch des Tages | " +new SimpleDateFormat("EEEE dd.MM.yyyy").format(new Date()));
        headLabel.setBorder(new EmptyBorder(5, 5, 10, 10));
        headLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        headLabel.setForeground(Color.GRAY);
        mainContainer.add(headLabel, BorderLayout.NORTH);

        String message = "";
        switch (randomInteger(1,5)) {
            case 1:
                message = "Spruch 1: Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. ";
                break;
            case 2:
                message = "Spruch 2: Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. ";
                break;
            case 3:
                message = "Spruch 3: Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. ";
                break;
            case 4:
                message = "Spruch 4: Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. ";
                break;
            case 5:
                message = "Spruch 5: Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. Lirum Larum Löffelstiel. ";
                break;
        }

        JTextArea textArea = new JTextArea(message);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBorder(new EmptyBorder(5, 5, 0, 0));
        //mainContainer.add(textArea, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 100));
        mainContainer.add(scrollPane, BorderLayout.CENTER);

/*
        String categories[] = { "Household", "Office", "Extended Family",
        "Company (US)", "Company (World)", "Team", "Will",
        "Birthday Card List", "High School", "Country", "Continent",
        "Planet" };
        JList list = new JList(categories);
*/
    }

    public int randomInteger(int min, int max) {
        Random rand = new Random();
        // nextInt excludes the top value so we have to add 1 to include the top value
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
