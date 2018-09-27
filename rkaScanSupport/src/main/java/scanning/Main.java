package scanning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static final List<LookupWordsTO> LOOKUP_WORDS_LIST = LookupWords.buildFromFile();

    public static void main(String[] args) throws IOException {

        String filename = "H:\\Dropbox\\___temp_SCAN\\Ohne Titel_b.pdf";

        PdfDatei pdfDatei = new PdfDatei(filename);
        Scanning s = new Scanning();
        String newFileNamePart = s.wordMatch(pdfDatei.getWortListe(), LOOKUP_WORDS_LIST);
        logger.info("New Filename Part: " +newFileNamePart);

//
//        ReadPdfAndLookupInDictionary r = new ReadPdfAndLookupInDictionary();
//        r.start();
    }

}
