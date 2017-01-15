package Fach_2_Objektorientierung.A11__Enums;

/**
 * Created by rk on 01.11.16.
 */
public enum Jahreszeit {
    FRUEHLING, SOMMER, HERBST, WINTER;

    //kann auch eigene Methoden haben
    public boolean istMuetzeNotwendig(){
        if ( this == WINTER) {
            return true;
        } else {
            return false;
        }
    }
}
