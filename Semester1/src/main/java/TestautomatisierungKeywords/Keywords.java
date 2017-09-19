package TestautomatisierungKeywords;

import com.borland.silk.keyworddriven.annotations.Argument;
import com.borland.silk.keyworddriven.annotations.Keyword;

public class Keywords {


  // dies hier dient alles dazu, dass auf der SILK TESTSUITE dann der Automatisierer (Person) sich nicht mit technischen
  // Begriffen wie dem Methodennamen "myKeyword" oder Parameternamen "userNameX" rumschlagen muss.
  // In der Silk Testsuite verwendet er dann "Login auf Webseite" und "Benutzername"
  // Instanziert wird diese Klasse durch die SILK TESTSUITE
  // beispiele keywords:
  // - öffne webseite V20
  // - öffne dialog
  // - erstelle parkbewilligung
  // - überprüfe pdf beleg
  @Keyword("Login auf Webseite")
  public void myKeyword(@Argument("Benutzername") String userNameX) {

    System.out.println(userNameX); // dies hier ist dann der effektive Test, z.B. Selenium. Hier im Beispiel einfach SOUT

  }
}