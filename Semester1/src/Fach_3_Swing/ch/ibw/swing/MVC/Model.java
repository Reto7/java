package Fach_3_Swing.ch.ibw.swing.MVC;

/**
 * Created by user on 26.12.2016.
 */
public class Model {

    private int x;

    /* constructors */
    public Model(){
        x = 0;
    }
    public Model(int x){
        this.x = x;
    }

    /* increment */
    public void incX(){
        x++;
    }

    public int getX(){
        return x;
    }
}