package Fach_1_Java_Grundlagen.A4; /**
 * Created by rk on 30.08.16.
 */

import Prog1Tools.IOTools;


public class TestImport {

    public static void main(String[] args) {
        System.out.println("Start");
        int i;
        i = IOTools.readInteger();
        System.out.println("i : " +i);
        System.out.println("Ende");
    }
}
