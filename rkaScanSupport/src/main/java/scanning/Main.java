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
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static final String PDF_FILES_DIRECTORY = "H:\\DATEN\\Rechnungen\\Belege\\GEMISCHT2";

    public static List<LookupWordsTO> lookupWordsTOList = LookupWords.buildWordList();

    public static void main(String[] args) throws IOException, InterruptedException {

        java.util.logging.Logger.getLogger("org.apache.pdfbox")
                .setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.fontbox")
                .setLevel(java.util.logging.Level.OFF);

        int counter = 0;

        // Win Explorer
        Runtime.getRuntime().exec("explorer.exe /select," + PDF_FILES_DIRECTORY);

        // Endless Loop, Wait 1 Sec
        for (;;) {
            try {
                long startTime = getStartTime();

//            //reload lookupExcel?
//            Date excelLookupFileLASTMODIFIED = new Date(new File(Const.WORDLIST_SRC_EXCEL_FILE).lastModified());
//            System.out.println("--- last mod ---" + excelLookupFileLASTMODIFIED);
//            long secondsSeitLetzterExcelAenderung = (excelLookupFileLASTMODIFIED.getTime() -  new Date().getTime())/1000;
//            System.out.println("--- since secs ---" + secondsSeitLetzterExcelAenderung);
//            if (secondsSeitLetzterExcelAenderung < 5) {
//                System.out.println("--- RELOAD EXCEL! ---");
//                lookupWordsTOList = LookupWords.buildWordList();
//            }

                // START
                File[] files = new File(PDF_FILES_DIRECTORY).listFiles();
                logger.info("Anzahl Files: " + files.length);
                for (File file : files) {
                    if (file.isDirectory()) {
                        //null //logger.debug("Directory: " + file.getName());
                    } else if (file.getName().endsWith("_PDF.pdf")) {
                        //null
                    } else if (file.getName().startsWith("19")) {  //1988
                        //null
                    } else if (file.getName().startsWith("20")) {  //2018
                        //null
                    } else {
                        logger.info("--------------------------------------------------------");
                        logger.info("File: " + file.getName());
                        logger.info("--------------------------------------------------------");
                        bearbeiteDatei(file);
                    }
                }
                long endTime = getEndTime();
                long runningTime = getRunnedTimeInMillisec(startTime,endTime);
                System.out.println("********************************************** running time: " + runningTime +" *****************************");
                if (runningTime < 2000) {
                    Thread.sleep(2000);
                    //
                    counter++;
                    if (counter==5) {
                        lookupWordsTOList = LookupWords.buildWordList();
                        counter=0;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //restart
            }
        }
    }

    private static long getEndTime() {
        long endTime = System.nanoTime();
        return endTime;
    }

    private static long getStartTime() {
        long startTime = System.nanoTime();
        return startTime;
    }

    private static long getRunnedTimeInMillisec(long startTime, long endTime) {
        long duration = (endTime - startTime);
        return duration / 1000000; //divide by 1000000 to get milliseconds.
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
            newFileNamePartByWordLookupMatch = s.getFileNamePartByWordLookupMatch(pdfDatei.getWortListe(), lookupWordsTOList);
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


//    private boolean isExcelLookupFileUpdated( File file ) {
//        file = file;
//        timeStamp = file.lastModified();
//
//        if( timeStamp != timeStamp ) {
//            timeStamp = timeStamp;
//            //Yes, file is updated
//            return true;
//        }
//        //No, file is not updated
//        return false;
//    }

}
