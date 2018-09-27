package scanning;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PdfDatei {

    private static final Logger logger = LoggerFactory.getLogger(PdfDatei.class);
    private String pdfFileName;

    public PdfDatei(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }

    public List<String> getWortListe() throws IOException {
        logger.info("");
        List<String> pdfWordListAlle = new ArrayList<String>();

        //try (PDDocument document = PDDocument.load(new File("/home/rk/Dropbox/___temp_SCAN/Ohne Titel_b.pdf"))) {
        try (PDDocument document = PDDocument.load(new File(this.pdfFileName))) {

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
                 // logger.debug(line);
                    List<String> pdfWortListe = Arrays.asList(line.split(" "));
                    for ( String pdfWort : pdfWortListe) {
                        logger.debug(pdfWort);
                        pdfWordListAlle.add(pdfWort);
                    }

                }

            }

        }
        logger.debug("PDF Datei Wortliste: " +pdfWordListAlle.size());
        return pdfWordListAlle;
    }

}
