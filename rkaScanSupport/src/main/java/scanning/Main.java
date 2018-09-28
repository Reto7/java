package scanning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static final List<LookupWordsTO> LOOKUP_WORDS_LIST = LookupWords.buildFromFile();


    public static void main(String[] args) throws IOException {

//      String filename = "H:\\Dropbox\\___temp_SCAN\\Ohne Titel_b.pdf";  // TODO LOOP, alles ohne *_PDF.pdf
//      String filename = "/home/rk/Dropbox/___temp_SCAN/Ohne Titel_b.pdf";  // TODO LOOP, alles ohne *_PDF.pdf

        File[] files = new File("/home/rk/Dropbox/___temp_SCAN/").listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                logger.debug("Directory: " + file.getName());
            } else {
                System.out.println("File: " + file.getName());
                bearbeiteDatei(file); // Calls same method again.
            }
        }




    }

    private static void bearbeiteDatei(File file) throws IOException {
        logger.debug("File: " + file.getAbsolutePath());
        PdfDatei pdfDatei = new PdfDatei(file.getAbsolutePath());
        Scanning s = new Scanning();

        String newFileNamePartByDateLookup = null;
        newFileNamePartByDateLookup = s.getFileNamePartByDateLookup(pdfDatei.getPdfText());
        logger.info("newFileNamePartByDateLookup: " +newFileNamePartByDateLookup);

        String newFileNamePartByWordLookupMatch = null;
        try {
            newFileNamePartByWordLookupMatch = s.getFileNamePartByWordLookupMatch(pdfDatei.getWortListe(), LOOKUP_WORDS_LIST);
            logger.info("newFileNamePartByWordLookupMatch: " +newFileNamePartByWordLookupMatch);

            //*******************************
            // RENAME
            //*******************************
            String newFilename = newFileNamePartByDateLookup + "_" +newFileNamePartByWordLookupMatch +"_PDF.pdf";
            logger.info("-------------------------------------");
            logger.info("NEW FILENAME: " +newFilename);
            logger.info("-------------------------------------");
            String path = file.getPath(); //new File(filename).getParent();
            System.out.println("path "+ path);
            //s.renameFile(filename,path+"/"+newFilename); // TODO

        } catch (NoMatchingLookupWordsException e) {
            logger.info("newFileNamePartByWordLookupMatch No Matchup");
        }

    }

}
