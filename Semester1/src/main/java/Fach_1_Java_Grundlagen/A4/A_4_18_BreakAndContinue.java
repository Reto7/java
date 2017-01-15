package Fach_1_Java_Grundlagen.A4;

/**
 * Created by user on 02.09.2016.
 * siehe auch Schleifen.java
 */
public class A_4_18_BreakAndContinue {
      public static void main(String args[]) {
          /*
          Die for-Schleife iteriert über alle (ganzen) Zahlen von (einschließlich) 0 bis (ausschließlich) 100
          bei 74 wird die Schleife aber durch die break-Anweisung vorzeitig abgebrochen.
          Solange werden alle Zahlen, die Vielfache von 9 sind, mittels System.out.println ausgegeben
          (bei Zahlen, die keine Vielfache von 9 sind, wird durch die continue-Anweisung zu nächsten Iteration
          übergegangen, bevor das System.out.println ausgeführt wird).
          Die letzte durch die for-Schleife ausgegebene Zahl ist 72.
           */
             for(int i = 0; i < 100; i++) {
                 if(i == 74) break;  // EXIT ganzer for loop abbrechen
                 if(i % 9 != 0) continue; // SKIP zum naechsten im loop (also alle nachfolgenden zeilen uebergehen)
                 System.out.println(i);
                 }
             /*
            Die while-Schleife ist keine Endlos-Schleife, weil sie abgebrochen wird, sobald j den Wert 1260 hat
            (da 1260 ein Vielfaches von 30 ist, tritt dieser Fall auch tatsächlich ein).
            Bis dahin werden alle Werte von i ausgegeben, die ein Vielfaches von 10 sind.
             */
             int i = 0;
             while(true) { // Endlosschleife? NEIN wegen break bei 1260
                 i++;
                 int j = i * 30;
                 if(j == 1260) break;
                 if(i % 10 != 0) continue;
                 System.out.println(i);
                 }
             }
             /*
             0


              */
}
