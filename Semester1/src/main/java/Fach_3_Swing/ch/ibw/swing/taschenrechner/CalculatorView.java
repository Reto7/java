
package Fach_3_Swing.ch.ibw.swing.taschenrechner;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/** Die Repraesentionsklasse (View) unseres Taschenrechners erweitert
 *  die Klasse JPanel und erbt damit alle Eigenschaften von JPanel.
 *  Die Repraesentionsklasse ist damit (u.a.) eine (J)Komponente
 *  und kann somit in beliebigen (J)Containern plaziert werden. 
 *   
 */
public class CalculatorView extends JPanel{
    
    /* private Referenz auf die Anzeige des Taschenrechners */ 
    private JTextField anzeige;
    
    public CalculatorView(){
        // Die folgenden beiden Kommentarzeilen muessen wir
        // fuer die letzte Aufgabe wieder einkommentieren
        // +++++++++++++++++++++++++++++++++
        CalculatorModel cm = new CalculatorModel();
        CalculatorController cc = new CalculatorController(this,cm);
        
        /* BorderLayout */
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300,300));
       
        /* Anzeige erzeugen und in die Mitte platzieren */
        anzeige = new JTextField();
        add(anzeige,BorderLayout.CENTER);

        JPanel rahmen = new JPanel();
        rahmen.setBorder(new EmptyBorder(2, 2, 2, 2));
        add(rahmen,BorderLayout.SOUTH);

        rahmen.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JPanel ziffernBlock = new JPanel(new GridLayout(4,3));

        
        // Das temporaere Panel muss nun noch mit Inhalt
        // gefuellt werden. Damit eine aehnliche Repraesention
        // wie auf den Folien erreicht wird, dafuer brauchen wir JButtons
        // fuer die Ziffern '0' ... '9' , '.' und Operatoren
        // '+','-','*','-','=','C' sowie (leere) JLabels um nicht
        // benoetigten Luecken im Grid zu fuellen.
        // Hinweis : Das GridLayout wird von links nach rechts und
        // von oben nach unten gefuellt ...
        
       
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JLabel dummy1 = new JLabel("");
        JButton b0 = new JButton("0");


        ziffernBlock.add(b1);
        ziffernBlock.add(b2);
        ziffernBlock.add(b3);
        ziffernBlock.add(b4);
        ziffernBlock.add(b5);
        ziffernBlock.add(b6);
        ziffernBlock.add(b7);
        ziffernBlock.add(b8);
        ziffernBlock.add(b9);
        ziffernBlock.add(dummy1);
        ziffernBlock.add(b0);

        rahmen.add(ziffernBlock,BorderLayout.WEST);


        /* temporaeres Panel erzeugen und im Sueden platzieren */
        JPanel operationsBlock = new JPanel(new GridLayout(4,2));

        JButton o1 = new JButton("+");
        JButton o2 = new JButton("-");
        JButton o3 = new JButton("*");
        JButton o4 = new JButton("/");
        JButton o5 = new JButton("C");
        JButton o6 = new JButton(".");
        JButton o7 = new JButton("=");

        operationsBlock.add(o1);
        operationsBlock.add(o2);
        operationsBlock.add(o3);
        operationsBlock.add(o4);
        operationsBlock.add(o5);
        operationsBlock.add(o6);
        operationsBlock.add(o7);



        o1.addActionListener(cc); // Füge Listener zu Button
        o2.addActionListener(cc); // Füge Listener zu Button
        o3.addActionListener(cc); // Füge Listener zu Button
        o4.addActionListener(cc); // Füge Listener zu Button
        o5.addActionListener(cc); // Füge Listener zu Button
        o6.addActionListener(cc); // Füge Listener zu Button
        o7.addActionListener(cc); // Füge Listener zu Button

        b1.addActionListener(cc); // Füge Listener zu Button
        b2.addActionListener(cc); // Füge Listener zu Button
        b3.addActionListener(cc); // Füge Listener zu Button
        b4.addActionListener(cc); // Füge Listener zu Button
        b5.addActionListener(cc); // Füge Listener zu Button
        b6.addActionListener(cc); // Füge Listener zu Button
        b7.addActionListener(cc); // Füge Listener zu Button
        b8.addActionListener(cc); // Füge Listener zu Button
        b9.addActionListener(cc); // Füge Listener zu Button
        b0.addActionListener(cc); // Füge Listener zu Button


        rahmen.add(operationsBlock,BorderLayout.EAST);
    }
    
    
    /**
     * Setter Methode um den Anzeigentext zu manipulieren 
     * 
     * @param text - String 
     */
    public void setAnzeige(String text){
        anzeige.setText(text);
    }

  

}
