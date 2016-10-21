package Fach_2_Objektorientierung.A90_JavaInsel_Interfaces;

public class Magazine extends GameObject implements Buyable2
{
    double price;

    @Override public double price()
    {
        if (this.price == 0.0) {
            return 7.80;
        } else {
            return price;
        }

    }

    @Override
    public boolean start(String irgendwas) {
        return false;
    }


}