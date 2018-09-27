package scanning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Scanning {

    private static final Logger logger = LoggerFactory.getLogger(Scanning.class);

    public String wordMatch(List<String> pdfWordList, List<LookupWordsTO> lookupWordsList){
        for (LookupWordsTO lookupWordsTO : lookupWordsList) {
            logger.debug(lookupWordsTO.toString());
            int lookupWordList = lookupWordsTO.getWordList().size();
            logger.debug("LookupWordlist size: "+ lookupWordList);

            int countWordMatches = countMatch(lookupWordsTO.getWordList(), pdfWordList);
            logger.debug("Words matching: " +countWordMatches);

            if (lookupWordList == countWordMatches) {
                logger.debug("--> Full Match!");  // TODO jetzt feld 1 und 2 fuer rename verwenden!
                return lookupWordsTO.getzielKategorie()+"_"+lookupWordsTO.getzielName();
            }

        }
        return "";
    }

    private static int countMatch(List<String> list1,List<String> list2) {
        //List<String> list1 = new ArrayList(Arrays.asList(a));
        //List<String> list2 = Arrays.asList(b);
        list1.retainAll(list2);
        return list1.size();
    }

}
