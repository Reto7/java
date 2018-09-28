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
    private String pdfTextInhalt;

    public PdfDatei(String pdfFileName) {
        this.pdfFileName = pdfFileName;
        try {
            this.pdfTextInhalt = getPdfText();
        } catch (IOException e) {
        }
    }

    public String getPdfText() throws IOException {
        logger.info("");
        if (this.pdfTextInhalt == null) {
            String pdfFileTextInhalt = "";
            try (PDDocument document = PDDocument.load(new File(this.pdfFileName))) {
                document.getClass();
                if (!document.isEncrypted()) {
                    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                    stripper.setSortByPosition(true);
                    PDFTextStripper tStripper = new PDFTextStripper();
                    pdfFileTextInhalt = tStripper.getText(document);
                    //clean
                    if (pdfFileTextInhalt.contains("\t")) {
                        pdfFileTextInhalt = pdfFileTextInhalt.replace("\t", " ");
                    }
                    document.close();
                }
            }
            this.pdfTextInhalt = pdfFileTextInhalt;
        }
        return this.pdfTextInhalt;
    }

    public List<String> getWortListe() throws IOException {
        logger.info("");
        List<String> pdfWordListAlle = new ArrayList<String>();
        String pdfFileInText = this.pdfTextInhalt;
        splitTextIntoWordList(pdfWordListAlle, pdfFileInText);
        logger.debug("PDF Datei Wortliste: " +pdfWordListAlle.size());
        return pdfWordListAlle;
    }

    private void splitTextIntoWordList(List<String> pdfWordListAlle, String pdfFileInText) {
        // split by whitespace
        String lines[] = pdfFileInText.split("\\r?\\n");
        for (String line : lines) {
         // logger.debug(line);
            List<String> pdfWortListe = Arrays.asList(line.split(" "));
            for ( String pdfWort : pdfWortListe) {
             // logger.debug(pdfWort); // TODO ENABLE FUER DEBUG
                pdfWordListAlle.add(pdfWort);
            }

        }
    }

}
