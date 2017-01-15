package Fach_2_Objektorientierung.A11_4_Generics;

/**
 * Created by rk on 01.11.16.
 */
public class TierKaefigTest {
    public static void main(String[] args) {

        // nicht ok, inkompatible typen, required:tier found:katze
        //TierKaefig<Tier> kaefig = new TierKaefig<Katze>();

        //TierKaefig<Hund> kaefig2 = new TierKaefig<Tier>();


        TierKaefig<?> kaefig3 = new TierKaefig<Katze>();
        //kaefig3.setInsasse(new Katze());


        TierKaefig kaefig4 = new TierKaefig();
        kaefig4.setInsasse(new Hund());
    }
}
