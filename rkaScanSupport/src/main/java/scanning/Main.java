package scanning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static final List<LookupWordsTO> LOOKUP_WORDS_LIST = LookupWords.buildWordList();
    public static final String PDF_FILES_DIRECTORY = "H:\\DATEN\\Rechnungen\\Belege\\GEMISCHT";

    public static void main(String[] args) throws IOException {

        java.util.logging.Logger.getLogger("org.apache.pdfbox")
                .setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.fontbox")
                .setLevel(java.util.logging.Level.OFF);


        File[] files = new File(PDF_FILES_DIRECTORY).listFiles();
        logger.info("Anzahl Files: " +files.length);
        for (File file : files) {
            if (file.isDirectory()) {
                logger.debug("Directory: " + file.getName());
            } else if (file.getName().endsWith("_PDF.pdf")) {
                //  alles mit *_PDF.pdf nicht nochmals behandeln
            } else if (file.getName().startsWith("2005")) {
            } else if (file.getName().startsWith("2006")) {
            } else if (file.getName().startsWith("2007")) {
            } else if (file.getName().startsWith("2008")) {
            } else if (file.getName().startsWith("2009")) {
            } else if (file.getName().startsWith("2010")) {
            } else if (file.getName().startsWith("2011")) {
            } else if (file.getName().startsWith("2012")) {
            } else if (file.getName().startsWith("2013")) {
            } else if (file.getName().startsWith("2014")) {
            } else if (file.getName().startsWith("2015")) {
            } else if (file.getName().startsWith("2016")) {
            } else if (file.getName().startsWith("2017")) {
            } else if (file.getName().startsWith("2018")) {
            } else if (file.getName().startsWith("2019")) {
            } else if (file.getName().startsWith("2020")) {
            } else if (file.getName().startsWith("2021")) {
            } else if (file.getName().startsWith("2022")) {
            } else if (file.getName().startsWith("2023")) {
            } else {
                logger.info("--------------------------------------------------------");
                logger.info("File: " + file.getName());
                logger.info("--------------------------------------------------------");
                bearbeiteDatei(file);
            }
        }
    }

    private static void bearbeiteDatei(File file) throws IOException {
      //logger.debug("File: " + file.getAbsolutePath());

        PdfDatei pdfDatei = new PdfDatei(file.getAbsolutePath());  // hier werden die PDF Worte ermittelt
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
            logger.info("NEW FILENAME: " + newFilename);
            logger.info("OLD FILENAME: " + file.getName());
            String path = file.getParent(); //new File(filename).getParent();
          //System.out.println("path " + path);
          //System.out.println("datei " + file.getAbsolutePath());
            s.renameFile(file.getAbsolutePath(),path+"/"+newFilename); // TODO
        } else {
            logger.info("NEW FILENAME: " + file.getName());
            logger.info("OLD FILENAME: " + file.getName());
        }
    }

    private static String getFileNamePartByFileCreationDate(File file) {
        logger.info("");
        // kein datum im text gefunden
        // verwenden creation date des files
//        BasicFileAttributes attr = null;
//        try {
//            Path p = Paths.get(file.getPath());
//            BasicFileAttributes view
//                    = Files.getFileAttributeView(p, BasicFileAttributeView.class)
//                    .readAttributes();
//            logger.debug("File creation date: " +String.valueOf(attr.creationTime()));
//            return String.valueOf(attr.creationTime());
//        } catch (IOException | NullPointerException e) {
//        }

        Path path = Paths.get(file.getPath());
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("**************** creationTime: " + attr.creationTime());
            long cTime = attr.creationTime().toMillis();
            ZonedDateTime t = Instant.ofEpochMilli(cTime).atZone(ZoneId.of("UTC"));
            String dateCreated = DateTimeFormatter.ofPattern("yyyy_MM_dd").format(t).replace(":","");
            System.out.println("**************** :" +dateCreated);
            return dateCreated;
        } catch (IOException e) {
            System.out.println("oops error! " + e.getMessage());
            return "__error_date__";
        }
    }

}
