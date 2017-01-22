package Fach_3_Swing.ch.ibw.swing.Aufgaben;

import javax.swing.*;
import java.awt.*;

/** Erzeuge ein Swing-Fenster mit Liste */
public class RetoGui2Start  {

  public static void main(String[] args) {
    RetoGui2 fenster = new RetoGui2();
    fenster.setTitle("Frame mit Liste");
    fenster.setSize(240,160);
    fenster.setVisible(true);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
