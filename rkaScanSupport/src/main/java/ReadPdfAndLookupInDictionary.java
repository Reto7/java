import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadPdfAndLookupInDictionary {

    public static void main(String[] args) throws IOException {

        List<String> pdfWordList = new ArrayList<String>();


        try (PDDocument document = PDDocument.load(new File("/home/rk/Dropbox/___temp_SCAN/Ohne Titel_b.pdf"))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
//                    System.out.println(line);

                    String[] arr = line.split(" ");
                    for ( String ss : arr) {
                        System.out.println(ss);
                        pdfWordList.add(ss);
                    }
                }

            }

        }
        System.out.println("*** Count number of strings that match in two arrays in Java ***");
        System.out.println("Array word size: "+pdfWordList.size());
        List<String> findWordList = new ArrayList<String>();
        findWordList.add("Reto");
        findWordList.add("Kaufmann");
        int countWordMatches = countMatch(findWordList, pdfWordList);
        System.out.println("Words matching: " +countWordMatches);

    }

    public static int countMatch(List<String> list1,List<String> list2) {
        //List<String> list1 = new ArrayList(Arrays.asList(a));
        //List<String> list2 = Arrays.asList(b);
        list1.retainAll(list2);
        return list1.size();
    }
}
