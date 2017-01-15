package MiniPersonenVerwaltung.applikation;

public class Person
{
  private String name;
  private int geburt;
  private double gehalt;
  
  public String getName()
  {
    return name;
  }
  public void setName(String pName)
  {
    name = pName;
  }
  
  
  public int getGeburt()
  {
    return geburt;
  }
  public void setGeburt(int geburt)
  {
    this.geburt = geburt;
  }
  public double getGehalt()
  {
    return gehalt;
  }
  public void setGehalt(double gehalt)
  {
    this.gehalt = gehalt;
  }
}
