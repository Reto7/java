package Fach_2_Objektorientierung.A11_Michele_Generics.generic2;

class Util
{
    public static   <T> T zufall( T m, T n )
    {
        return Math.random() > 0.5 ? m : n;
    }
}