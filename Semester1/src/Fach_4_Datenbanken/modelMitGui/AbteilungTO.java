package Fach_4_Datenbanken.modelMitGui;

public class AbteilungTO {
  private String abt_nr;
  private String leiter;
  private String name;
  private String ort;

  public String getAbt_nr() {
    return abt_nr;
  }

  public void setAbt_nr(String abt_nr) {
    this.abt_nr = abt_nr;
  }

  public String getLeiter() {
    return leiter;
  }

  public void setLeiter(String leiter) {
    this.leiter = leiter;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  //**************************
  public String toString() {
    return this.abt_nr +" " +this.name +" " +this.ort +", Leiter:" +this.leiter;
  }
}
