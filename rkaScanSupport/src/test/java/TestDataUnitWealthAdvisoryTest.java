import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestDataUnitWealthAdvisoryTest {

//    private static final Logger logger = LoggerFactory.getLogger(TestDataUnitWealthAdvisoryTest.class);

    private LookupWords LookupWords = new LookupWords();


    @Test(groups = "Unit")
    public void testJsonToJavaBeanConvertionShouldCreateInstances(){
        List<LookupWordsTO> lookupWordsTOList = LookupWords.buildFromFile("LookupWords.json");
        Integer numberOfTestDataObjects = lookupWordsTOList.size();
        System.out.println("Unit Testing the Tests: Number of Testdata: " +numberOfTestDataObjects);
        Assert.assertTrue(numberOfTestDataObjects > 2);
        Assert.assertTrue(lookupWordsTOList.get(0) instanceof LookupWordsTO);
        //
        for (LookupWordsTO lookupWordsTO : lookupWordsTOList) {
            System.out.println(lookupWordsTO.toString());
            System.out.println("Wordlist size: "+lookupWordsTO.getWordList().size());
        }
    }

}
