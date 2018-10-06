package scanning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LookupWordsTest {

    private static final Logger logger = LoggerFactory.getLogger(LookupWordsTest.class);

    private LookupWords LookupWords = new LookupWords();


    @Test
    public void testJsonToJavaBeanConvertionShouldCreateInstances(){
        List<LookupWordsTO> lookupWordsTOList = LookupWords.buildWordList();
        Integer numberOfTestDataObjects = lookupWordsTOList.size();
        logger.debug("Unit Testing the Tests: Number of Testdata: " +numberOfTestDataObjects);
        Assert.assertTrue(numberOfTestDataObjects > 2);
        Assert.assertTrue(lookupWordsTOList.get(0) instanceof LookupWordsTO);
        //
        for (LookupWordsTO lookupWordsTO : lookupWordsTOList) {
            logger.debug(lookupWordsTO.toString());
          //  logger.debug("Wordlist size: "+lookupWordsTO.getWordList().size());
        }
    }

}
