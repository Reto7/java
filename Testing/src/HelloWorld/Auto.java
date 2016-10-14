package HelloWorld;

/**
 * Created by rk on 14.10.16.
 */
public class Auto {

    //constructors
    public Auto() {
        this.farbe = "blau";  // grundsaetzlich ist ein auto immer blau!
    }
    public Auto(String farbe) {
        this.farbe = farbe;
    }

    String farbe;

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
}
