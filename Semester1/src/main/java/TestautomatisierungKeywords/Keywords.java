package TestautomatisierungKeywords;

import com.borland.silk.keyworddriven.annotations.Argument;
import com.borland.silk.keyworddriven.annotations.Keyword;

public class Keywords {


  @Keyword("Wer ist da")
  public void myKeyword(@Argument("Benutzername") String name) {
    System.out.println(name);
  }
}