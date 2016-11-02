package ch.ibw.generic;

/** Diese Klasse repraesentiert Ringobjekte, die nach
 ihrer Groesse sortiert werden koennen. */
public class Ring implements Comparable <Ring>{

  /** Durchmesser */
  private double durchmesser;

  /** Konstruktor */
  public Ring(double durchmesser) {
    this.durchmesser = durchmesser;
  }

  /** Gibt den Durchmesser in der toString-Methode aus */
  public String toString() {
    return "Ring der Groesse " + durchmesser;
  }

  /** Mit Hilfe der compareTo-Methode wird verglichen */
  public int compareTo(Ring o) {
    double durchmesser2 = o.durchmesser;
    if (durchmesser < durchmesser2)  
      return -1;                     // Fall 1
    if (durchmesser > durchmesser2)
      return 1;                      // Fall 2
    return 0;                        // Fall 3 
  }

  /** Die equals-Methode muss auf den Vergleich abgestimmt werden */
  public boolean equals(Object o) {
    if (o == null) 
      return false;
    if (this == o) 
      return true; 
    if (getClass() != o.getClass()) 
      return false;
    return compareTo((Ring) o) == 0;
  }

  /** Wer die equals-Methode veraendert, muss auch die
    * hashCode-Methode veraendern. */
  public int hashCode() {
    return (new Double(durchmesser)).hashCode();
  }

}
