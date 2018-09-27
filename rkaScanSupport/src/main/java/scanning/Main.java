package scanning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static final List<LookupWordsTO> LOOKUP_WORDS_LIST = LookupWords.buildFromFile();


    public static void main(String[] args) throws IOException {

        String filename = "H:\\Dropbox\\___temp_SCAN\\Ohne Titel_b.pdf";  // TODO LOOP, alles ohne *_PDF.pdf

        PdfDatei pdfDatei = new PdfDatei(filename);
        Scanning s = new Scanning();

        String newFileNamePartByWordLookupMatch = null;
        try {
            newFileNamePartByWordLookupMatch = s.getFileNamePartByWordLookupMatch(pdfDatei.getWortListe(), LOOKUP_WORDS_LIST);
            logger.info("newFileNamePartByWordLookupMatch: " +newFileNamePartByWordLookupMatch);
        } catch (NoMatchingLookupWordsException e) {
            logger.info("newFileNamePartByWordLookupMatch No Matchup");
        }

        String newFileNamePartByDateLookup = null;
        newFileNamePartByDateLookup = s.getFileNamePartByDateLookup(pdfDatei.getPdfText());
        logger.info("newFileNamePartByDateLookup: " +newFileNamePartByDateLookup);

        String newFilename = newFileNamePartByDateLookup + "_" +newFileNamePartByWordLookupMatch +"_PDF.pdf";
        logger.info("NEW FILENAME: " +newFilename);

        String path = new File(filename).getParent();
        //System.out.println("path "+ path);
        //s.renameFile(filename,path+"/"+newFilename);

    }

}
