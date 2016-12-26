package Fach_3_Swing.ch.ibw.swing.MVC.tableModel;

/**
 * Created by user on 26.12.2016.
 */
import javax.swing.SwingUtilities;

/**
 * @author ashraf_sarhan
 *
 */
public class SwingMVCDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void createAndShowGUI() throws Exception {
        new View();
    }
}