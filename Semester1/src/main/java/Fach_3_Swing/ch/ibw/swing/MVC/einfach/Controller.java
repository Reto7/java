package Fach_3_Swing.ch.ibw.swing.MVC.einfach;

/**
 * Created by user on 26.12.2016.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    /**
     * The Controller class keeps references to Model and View classes.
     * So Controller sees Model and View interfaces. Controller provides
     * interaction between Model and View. Method control() gets reference
     * to view's button and assign actionListener to it. In actionListener's
     * method actionPerformed() method linkBtnAndLabel() is called.
     * In linkBtnAndLabel() model's variable "x" increments and than "x"
     * sends to view's label to display changes.
     *
     * MVC helps to divide functionality between different objects, so program
     * becomes more clear and understandable. The pattern allows to modify code
     * (realization), that is encapsulated inside one of these classes without
     * intrusion inside other classes code(of course you have to keep the same
     * interfaces).
     */

    private Model model;
    private View view;
    private ActionListener actionListener;

    /* constructor */
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void control(){
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                linkBtnAndLabel();
            }
        };
        view.getButton().addActionListener(actionListener);
    }

    private void linkBtnAndLabel(){
        model.incX();
        view.setText(Integer.toString(model.getX()));
    }
}
