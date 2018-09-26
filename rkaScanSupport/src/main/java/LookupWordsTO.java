import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

public class LookupWordsTO {

  //private static final Logger logger = LoggerFactory.getLogger(WealthAdvisoryTestDataTO.class);

    @NotNull(message = "Test-Data (JSON) field cannot be null: zielKategorie")
    String zielKategorie;

    @NotNull(message = "Test-Data (JSON) field cannot be null: zielName")
    String zielName;

    @NotNull(message = "Test-Data (JSON) field cannot be null: w1")
    String w1;

    @NotNull(message = "Test-Data (JSON) field cannot be null: w2")
    String w2;

    @NotNull(message = "Test-Data (JSON) field cannot be null: w3")
    String w3;

    @NotNull(message = "Test-Data (JSON) field cannot be null: w4")
    String w4;


    public String getzielKategorie() {
        return zielKategorie;
    }

    public String getzielName() {
        return zielName;
    }

    public String getW1() {
        return w1;
    }

    public String getW2() {
        return w2;
    }

    public String getW3() {
        return w3;
    }

    public String getW4() {
        return w4;
    }

    public List<String> getWordList(){
        List<String> wordList = new ArrayList<>();
        if (w1.length() >1)
            wordList.add(w1);
        if (w2.length() >1)
            wordList.add(w2);
        if (w3.length() >1)
            wordList.add(w3);
        if (w4.length() >1)
            wordList.add(w4);
        return wordList;
    }

    @Override
    public String toString() {
        return "zielKategorie:" + zielKategorie
                +" | zielName:" + zielName
                +" | w1:" + w1
                +" | w2:" + w2
                +" | w3:" + w3
                +" | w4:" + w4
                ;
    }

    public void validate(){
     // logger.info("");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<LookupWordsTO>> violations = validator.validate(this);
        if (violations.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.getProperty("line.separator"));
            for (ConstraintViolation<LookupWordsTO> violation : violations) {
                sb.append(violation.getMessage());
                sb.append(System.getProperty("line.separator"));
            }
            System.out.println(sb.toString());
            throw new ValidationException("ERROR on test data: " + String.valueOf(sb));
        }
    }

}
