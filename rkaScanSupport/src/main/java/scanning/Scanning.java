package scanning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Scanning {

    private static final Logger logger = LoggerFactory.getLogger(Scanning.class);

    public String getFileNamePartByWordLookupMatch(List<String> pdfWordList, List<LookupWordsTO> lookupWordsList) throws NoMatchingLookupWordsException {
        for (LookupWordsTO lookupWordsTO : lookupWordsList) {
         // logger.debug(lookupWordsTO.toString());
            int lookupWordList = lookupWordsTO.getWordList().size();
            //logger.debug("LookupWordlist size: "+ lookupWordList);
            int countWordMatches = countMatch(lookupWordsTO.getWordList(), pdfWordList);
            logger.debug("Words matching: " +countWordMatches);
            if (lookupWordList == countWordMatches) {
                logger.debug("--> Full Match!");
                return lookupWordsTO.getzielKategorie()+"_"+lookupWordsTO.getzielName();
            }

        }
        throw new NoMatchingLookupWordsException();
    }

    public String getFileNamePartByDateLookup(String pdfText) {
        return getRelevantDateFromString(pdfText);
    }

    private static int countMatch(List<String> list1,List<String> list2) {
        //List<String> list1 = new ArrayList(Arrays.asList(a));
        //List<String> list2 = Arrays.asList(b);
        list1.retainAll(list2);
        return list1.size();
    }

    public String getRelevantDateFromString(String input) {
      //String input = "coming from the 01.12.1988 to the 12.01.2000";
        String[] elements = input.split(" ");
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        List<LocalDate> dates = new ArrayList<>();
        for (String element : elements) {
            try {
                LocalDate ld = LocalDate.parse(element, f);
                dates.add(ld);
            } catch (DateTimeParseException e) {
                // Ignore the exception. Move on to next element.
            }
        }
        //Collections.sort(dates, Collections.reverseOrder());
        LocalDate xmin = LocalDate.parse("2010-01-01"); //default, ISO_LOCAL_DATE
        //logger.debug("XMIN: " +xmin);
        //logger.debug("Anzahl Datum: " +dates.size());
        for (ListIterator<LocalDate> iter = dates.listIterator(); iter.hasNext(); ) {
            LocalDate datum = iter.next();
            if (datum.isBefore(xmin)) {
                logger.debug("delete");
                iter.remove();
            }
        }
        //logger.debug("Anzahl Datum: " +dates.size());
        Collections.sort(dates);
        //System.out.println(dates);
        if (dates.size() >0) {
            System.out.println(dates.get(0));
            return String.valueOf(dates.get(0)).replace("-", "_");
        } else {
            return null;
        }
    }

    public void renameFile(String oldNameAndPath, String newNameAndPath) {
        Path sourcePath      = Paths.get(oldNameAndPath);
        Path destinationPath = Paths.get(newNameAndPath);
        try {
            Files.move(sourcePath, destinationPath,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            //moving file failed.
            e.printStackTrace();
        }
    }
}
