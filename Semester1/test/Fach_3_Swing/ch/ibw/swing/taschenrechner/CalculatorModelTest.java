package Fach_3_Swing.ch.ibw.swing.taschenrechner;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rk on 13.12.16.
 */
public class CalculatorModelTest {


    CalculatorModel cm;
    Double ergb;

    public CalculatorModelTest() {
        cm = new CalculatorModel();
    }


    @Test
    public void t1() {

            /* 5.4 + 3 */
        cm.addZiffer('5');
        cm.addZiffer('.');
        cm.addZiffer('4');
        cm.setOperator(CalculatorModel.PLUS);
        cm.addZiffer('3');
        ergb = cm.berechne();
        Assert.assertEquals(new Double(8.4), ergb);
            /*
            if (ergb == 8.4){
                System.out.println("Test '+' erfolgreich!       :: 5.4+3 == 8.4");
            } else {
                System.out.println("Test '+' NICHT erfolgreich! :: 5.4+3 != "+ergb);
            }
            */
    }

    @Test
    public void t2() {

            /* Modell zuruecketzen */
        cm.reset();
            /*251 - 5 */
        cm.addZiffer('2');
        cm.addZiffer('5');
        cm.addZiffer('1');
        cm.setOperator(CalculatorModel.MINUS);
        cm.addZiffer('5');
        ergb = cm.berechne();
        Assert.assertEquals(new Double(246.0), ergb);
            /*
            if (ergb == 246) {
                System.out.println("Test '-' erfolgreich!       :: 251-5 == 246");
            } else {
                System.out.println("Test '-' NICHT erfolgreich! :: 251-5 != "+ergb);
            }
            */
    }

    @Test
    public void t3() {
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
        Assert.assertEquals(new Double(8.0), ergb);
            /*
            if (ergb == 8) {
                System.out.println("Test '/' erfolgreich!       :: 160/20 == 8");
            } else {
                System.out.println("Test '/' NICHT erfolgreich! :: 160/20 != "+ergb);
            }
            */
    }

    @Test
    public void t4() {
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
        Assert.assertEquals(new Double(4.62), ergb, new Double(0.000001));  // der 3. Parameter ist die maximale Abweichung beim Double Vergleich
            /*
            if (ergb == (2.1*2.2)) {
                System.out.println("Test '*' erfolgreich!       :: 2.1*2.2 == 4.62");
            } else {
                System.out.println("Test '*' NICHT erfolgreich! :: 2.1*2.2 != "+ergb);
            }
            */

    }

    @Test
    public void t5() {
            /* Modell zuruecksetzen */
        cm.reset();
            /* Operator nicht gesetzt */
        cm.addZiffer('5');
        ergb = cm.berechne();
        Assert.assertEquals(null, ergb);
            /*
            if (ergb == 0.0) {
                System.out.println("Test 'Operator nicht gesetzt' erfolgreich! 0.0 == 0.0");
            } else {
                System.out.println("Test 'Operator nicht gesetzt' NICHT erfolgreich ! 0.0 != "+ergb);
            }
            */

    }

    @Test
    public void t6() {
            /* Modell zuruecksetzen */
        cm.reset();
            /* Operand2 leer bzw. nicht gesetzt */
        cm.addZiffer('5');
        cm.setOperator(CalculatorModel.PLUS);
        ergb = cm.berechne();
        Assert.assertEquals(null, ergb);
            /*
            if (ergb == 5) {
                System.out.println("Test 'Operand2 leer bzw. nicht gesetzt' erfolgreich! 5 == 5");
            } else {
                System.out.println("Test 'Operand2 leer bzw. nicht gesetzt' NICHT erfolgreich! 5 != "+ergb);
            }
            */
    }


    @Test
    public void t7() {
            /* Modell zuruecksetzen */
        cm.reset();
            /* Operand2 leer bzw. nicht gesetzt */
        cm.addZiffer('.');
        cm.addZiffer('5');
        cm.setOperator(CalculatorModel.PLUS);
        cm.addZiffer('1');
        ergb = cm.berechne();
        Assert.assertEquals(new Double(1.5), ergb);
    }

    @Test
    public void t8() {
            /* Modell zuruecksetzen */
        cm.reset();
            /* Operand2 leer bzw. nicht gesetzt */
        cm.addZiffer('.');
        cm.setOperator(CalculatorModel.PLUS);
        cm.addZiffer('1');
        ergb = cm.berechne();
        Assert.assertEquals(new Double(1.0), ergb);
    }

    @Test
    public void t9() {
            /* Modell zuruecksetzen */
        cm.reset();
            /* Operand2 leer bzw. nicht gesetzt */
        cm.addZiffer('1');
        cm.setOperator(CalculatorModel.PLUS);
        cm.addZiffer('.');
        ergb = cm.berechne();
        Assert.assertEquals(new Double(1.0), ergb);
    }

}