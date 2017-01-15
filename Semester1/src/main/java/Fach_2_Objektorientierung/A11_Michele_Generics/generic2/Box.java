package Fach_2_Objektorientierung.A11_Michele_Generics.generic2;

class Box<  T  >
{
    private   T   val;
    void setValue(   T   val )
    {
        this.val = val;
    }
    T   getValue()
    {
        return val;
    }
}