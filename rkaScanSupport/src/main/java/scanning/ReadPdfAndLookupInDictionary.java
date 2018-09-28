package scanning;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadPdfAndLookupInDictionary {

    private static final Logger logger = LoggerFactory.getLogger(ReadPdfAndLookupInDictionary.class);

    public void start() throws IOException {

        List<String> pdfWordList = new ArrayList<String>();


        try (PDDocument document = PDDocument.load(new File("/home/rk/Dropbox/___temp_SCAN/Ohne Titel_b.pdf"))) {
        //try (PDDocument document = PDDocument.load(new File("H:\\Dropbox\\___temp_SCAN\\Ohne Titel_b.pdf"))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //logger.debug("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
//                    logger.debug(line);

                    String[] pdfWortListe = line.split(" ");
                    for ( String pdfWort : pdfWortListe) {
                        logger.debug(pdfWort);
                        pdfWordList.add(pdfWort);
                    }
                }

            }

        }
        logger.debug("*** Count number of strings that match in two arrays in Java ***");
        logger.debug("Array word size: "+pdfWordList.size());

        // lookup daten lesen
        List<LookupWordsTO> lookupWordsTOList = LookupWords.buildFromFile();
        for (LookupWordsTO lookupWordsTO : lookupWordsTOList) {
            logger.debug(lookupWordsTO.toString());
            int lookupWordList = lookupWordsTO.getWordList().size();
            //logger.debug("LookupWordlist size: "+ lookupWordList);

            int countWordMatches = countMatch(lookupWordsTO.getWordList(), pdfWordList);
            logger.debug("Words matching: " +countWordMatches);

            if (lookupWordList == countWordMatches) {
                logger.debug("--> Full Match!");  // TODO jetzt feld 1 und 2 fuer rename verwenden!
                return;
            }

        }


    }

    public int countMatch(List<String> list1,List<String> list2) {
        //List<String> list1 = new ArrayList(Arrays.asList(a));
        //List<String> list2 = Arrays.asList(b);
        list1.retainAll(list2);
        return list1.size();
    }
}
