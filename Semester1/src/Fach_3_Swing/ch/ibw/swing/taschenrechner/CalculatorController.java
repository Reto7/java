package Fach_3_Swing.ch.ibw.swing.taschenrechner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Die Steuerungsklasse (Controller) des Taschenrechners implementiert
 * die Klasse 'ActionListener'.
 */
public class CalculatorController implements ActionListener {
    
    /* private Referenz auf die Repraesentation */
    private CalculatorView cv;
    /* private Referenz auf das Modell */
    private CalculatorModel cm;
    
    
    /** 
     * Konstruktor
     * 
     * @param cv - Referenz auf die Repraesentation
     * @param cm - Referenz auf den Controller
     */
    public CalculatorController(CalculatorView cv, CalculatorModel cm){
        this.cv = cv;
        this.cm = cm;
        
    }

 
    /**
     * Implementierung der Funktion 'actionPerformed' von dem Interface
     * ActionListener 
     * 
     * @param e - ActionEvent e
     */
    public void actionPerformed(ActionEvent e) {
        /* Zunaechst betrachten wir die Ereignisse die einer
           gesonderten Behandlung beduerfen; die Operatoren.
           Die Ziffern koennen gemeinsam betrachtet werden. */
        if (e.getActionCommand().equals("+")) {
            cm.setOperator(CalculatorModel.PLUS);
            cv.setAnzeige("+");
      
        // Die Ereignisbehandlung fuer die Operatoren '-',
        // '*','/' und '=' muessen an dieser Stelle aehnlich 
        // implementiert werden.
        // +++++++++++++++++++++++++++++++++++++++++++++++
        } else if (e.getActionCommand().equals("C")){
            cm.reset();
            cv.setAnzeige("");
        } else {  
            // Die Ereignisbehandlung fuer die Ziffern
            // kann geschickt zusammengefasst werden!
            // Hinweis : e.getActionCommand() ... 
            
        }
             
        
    }

}
