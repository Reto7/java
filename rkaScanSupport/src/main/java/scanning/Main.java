package scanning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.UUID;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static final List<LookupWordsTO> LOOKUP_WORDS_LIST = LookupWords.buildFromFile();


    public static void main(String[] args) throws IOException {

//      String filename = "H:\\Dropbox\\___temp_SCAN\\Ohne Titel_b.pdf";
//      String filename = "/home/rk/Dropbox/___temp_SCAN/Ohne Titel_b.pdf";

        File[] files = new File("/home/rk/Dropbox/___temp_SCAN/").listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                logger.debug("Directory: " + file.getName());
            } else if (file.getName().endsWith("_PDF.pdf")) {
                //  alles mit *_PDF.pdf nicht nochmals behandeln
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

        String newFileNamePartByDate = null;
        newFileNamePartByDate = s.getFileNamePartByDateLookup(pdfDatei.getPdfText());
        if (newFileNamePartByDate == null) {
            newFileNamePartByDate = getFileNamePartByFileCreationDate(file);
        }
        logger.info("newFileNamePartByDateLookup: " +newFileNamePartByDate);

        String newFileNamePartByWordLookupMatch = null;
        try {
            newFileNamePartByWordLookupMatch = s.getFileNamePartByWordLookupMatch(pdfDatei.getWortListe(), LOOKUP_WORDS_LIST);
            logger.info("newFileNamePartByWordLookupMatch: " +newFileNamePartByWordLookupMatch);
        } catch (NoMatchingLookupWordsException e) {
            logger.info("newFileNamePartByWordLookupMatch No Matchup");
        }


        if (newFileNamePartByDate != null & newFileNamePartByWordLookupMatch != null) {
            //*******************************
            // RENAME
            //*******************************
            String random = UUID.randomUUID().toString().substring(1,8);
            String newFilename = newFileNamePartByDate + "_" + newFileNamePartByWordLookupMatch + "_" +random +"_PDF.pdf";
            logger.info("-------------------------------------");
            logger.info("NEW FILENAME: " + newFilename);
            logger.info("-------------------------------------");
            String path = file.getParent(); //new File(filename).getParent();
            System.out.println("path " + path);
            System.out.println("datei " + file.getAbsolutePath());
            s.renameFile(file.getAbsolutePath(),path+"/"+newFilename); // TODO
        } else {
            logger.info("-------------------------------------");
            logger.info("OLD FILENAME: " + file.getName());
            logger.info("-------------------------------------");
        }
    }

    private static String getFileNamePartByFileCreationDate(File file) {
        logger.info("");
        // kein datum im text gefunden
        // verwenden creation date des files
        BasicFileAttributes attr = null;
        try {
            Path p = Paths.get(file.getPath());
            BasicFileAttributes view
                    = Files.getFileAttributeView(p, BasicFileAttributeView.class)
                    .readAttributes();
            logger.debug("File creation date: " +String.valueOf(attr.creationTime()));
            return String.valueOf(attr.creationTime());
        } catch (IOException | NullPointerException e) {
        }
        return null;
    }

}
