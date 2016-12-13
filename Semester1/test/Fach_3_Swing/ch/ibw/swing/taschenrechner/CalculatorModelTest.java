package Fach_3_Swing.ch.ibw.swing.taschenrechner;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rk on 13.12.16.
 */
public class CalculatorModelTest {

    @Test
    public void t1() {

            CalculatorModel cm = new CalculatorModel();

            /* 5.4 + 3 */
            cm.addZiffer('5');
            cm.addZiffer('.');
            cm.addZiffer('4');
            cm.setOperator(CalculatorModel.PLUS);
            cm.addZiffer('3');
            Double ergb = cm.berechne();
            Assert.assertEquals(new Double(8.4),ergb);
            /*
            if (ergb == 8.4){
                System.out.println("Test '+' erfolgreich!       :: 5.4+3 == 8.4");
            } else {
                System.out.println("Test '+' NICHT erfolgreich! :: 5.4+3 != "+ergb);
            }
            */

            /* Modell zuruecketzen */
            cm.reset();
            /*251 - 5 */
            cm.addZiffer('2');
            cm.addZiffer('5');
            cm.addZiffer('1');
            cm.setOperator(CalculatorModel.MINUS);
            cm.addZiffer('5');
            ergb = cm.berechne();
            Assert.assertEquals(new Double(246.0),ergb);
            /*
            if (ergb == 246) {
                System.out.println("Test '-' erfolgreich!       :: 251-5 == 246");
            } else {
                System.out.println("Test '-' NICHT erfolgreich! :: 251-5 != "+ergb);
            }
            */

            /* Modell zuruecketzen */
            cm.reset();
            /*160 / 20 */
            cm.addZiffer('1');
            cm.addZiffer('6');
            cm.addZiffer('0');
            cm.setOperator(CalculatorModel.DURCH);
            cm.addZiffer('2');
            cm.addZiffer('0');
            ergb = cm.berechne();
            Assert.assertEquals(new Double(8.0),ergb);
            /*
            if (ergb == 8) {
                System.out.println("Test '/' erfolgreich!       :: 160/20 == 8");
            } else {
                System.out.println("Test '/' NICHT erfolgreich! :: 160/20 != "+ergb);
            }
            */
            /* Modell zuruecksetzen */
            cm.reset();
            /* 2.1 * 2.2 */
            cm.addZiffer('2');
            cm.addZiffer('.');
            cm.addZiffer('1');
            cm.setOperator(CalculatorModel.MAL);
            cm.addZiffer('2');
            cm.addZiffer('.');
            cm.addZiffer('2');
            ergb = cm.berechne();
            Assert.assertEquals(new Double(4.62),ergb);
            /*
            if (ergb == (2.1*2.2)) {
                System.out.println("Test '*' erfolgreich!       :: 2.1*2.2 == 4.62");
            } else {
                System.out.println("Test '*' NICHT erfolgreich! :: 2.1*2.2 != "+ergb);
            }
            */

            // TODO, Fehleingaben testen!
            /* Modell zuruecksetzen */
            cm.reset();
            /* Operator nicht gesetzt */
            cm.addZiffer('5');
            ergb = cm.berechne();
            Assert.assertEquals(CalculatorModel.DENMUESSENWIRLOSWERDEN, ergb);
            /*
            if (ergb == 0.0) {
                System.out.println("Test 'Operator nicht gesetzt' erfolgreich! 0.0 == 0.0");
            } else {
                System.out.println("Test 'Operator nicht gesetzt' NICHT erfolgreich ! 0.0 != "+ergb);
            }
            */

            // TODO, Fehleingaben testen!
            /* Modell zuruecksetzen */
            cm.reset();
            /* Operand2 leer bzw. nicht gesetzt */
            cm.addZiffer('5');
            cm.setOperator(CalculatorModel.PLUS);
            ergb = cm.berechne();
            Assert.assertEquals(CalculatorModel.DENMUESSENWIRLOSWERDEN, ergb);
            /*
            if (ergb == 5) {
                System.out.println("Test 'Operand2 leer bzw. nicht gesetzt' erfolgreich! 5 == 5");
            } else {
                System.out.println("Test 'Operand2 leer bzw. nicht gesetzt' NICHT erfolgreich! 5 != "+ergb);
            }
            */
    }

}