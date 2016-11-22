package Fach_3_Swing.ch.ibw.swing.A142_Swing_VierButtonFrame;

/**
 * Created by user on 19.11.2016.
 */
import java.awt.*;
import javax.swing.*;

public class VierButtonFrameWithRandomBackgr extends JFrame {
    Container c;
    JLabel beschriftung;

    public static int randomInt(int Min, int Max)
    {
        return (int) (Math.random()*(Max-Min))+Min;
    }

    private void setVisubleWithRandomBackground(JButton button){
        // RGB: Drei Werte von 0..255
        Color color = new Color(randomInt(0,255), randomInt(0,255), randomInt(0,255));
        String rgbColors = "RGB: " +color.getRed() +" " +color.getGreen() +" " +color.getBlue();
        System.out.println("Colors: " + rgbColors);
        //button.setBackground(Color.BLUE);
        button.setBackground(color);
        button.setToolTipText(rgbColors);
        c.add(button);
    }

    public VierButtonFrameWithRandomBackgr(int i) {
        c = getContentPane();
        if (i==1)
            c.setLayout(new FlowLayout());
        else if (i==2)
            c.setLayout(new BorderLayout());
        else if (i==3)
            c.setLayout(new GridLayout());
        else
            c.setLayout(new GridLayout(0,1));


        final JButton a = new JButton("A");
        setVisubleWithRandomBackground(a);

        final JButton b = new JButton("B");
        setVisubleWithRandomBackground(b);

        final JButton c = new JButton("C");
        setVisubleWithRandomBackground(c);

        final JButton d = new JButton("D");
        setVisubleWithRandomBackground(d);
    }

    public static void main(String[] args) {
        VierButtonFrameWithRandomBackgr[] fenster = new VierButtonFrameWithRandomBackgr[4];
        for (int i=0; i<4; i++) {
            fenster[i] = new VierButtonFrameWithRandomBackgr(i+1);
            fenster[i].setTitle("Fenster " + (i+1));
            fenster[i].setSize(200,200);
            fenster[i].setLocation(i*200,0);
            fenster[i].setVisible(true);
            fenster[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}