package Fach_2_Objektorientierung.A90_JavaInsel_Interfaces;

/*
aus http://openbook.rheinwerk-verlag.de/javainsel/javainsel_05_012.html#dodtpd2ed3e4a-d795-4c52-9357-cb640e8f256f
 */
public abstract class GameObject
{
    // alle Subklassen haben auch dieses namen Attribut von dieser Superklasse
    public String name;

    // diese muss von den Subklassen ueberschrieben werden!
    public abstract boolean start( String irgendwas );

}