package Fach_1_Java_Grundlagen.Kaufmann;

/**
 * Created by rk on 15.09.16.
 */
public class A5 {
    public static void main(String[] args) {

        int pressedNumbers = 5;

        // EINFACHE Lösung
        /*
        if (pressedNumbers >= 0 && pressedNumbers <= 9) {
            System.out.println("Taste " + pressedNumbers + " gedrückt");
        } else {
            System.out.println("Nicht erlaubt");
        }
        */

        // SWITCH-Lösung, wird in der Aufgabenstellung so erwartet
        boolean isOK;
        switch (pressedNumbers) {
            case 0:
                isOK = true;
                break;
            case 1:
                isOK = true;
                break;
            case 2:
                isOK = true;
                break;
            case 3:
                isOK = true;
                break;
            case 4:
                isOK = true;
                break;
            case 5:
                isOK = true;
                break;
            case 6:
                isOK = true;
                break;
            case 7:
                isOK = true;
                break;
            case 8:
                isOK = true;
                break;
            case 9:
                isOK = true;
                break;
            default:
                isOK = false;
        }

        if (isOK) {
            System.out.println("Taste " + pressedNumbers + " gedrückt");
        } else {
            System.out.println("Nicht erlaubt");
        }

    }
}
