package scanning;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelTest {

    public static final String SAMPLE_XLSX_FILE_PATH = "C:\\temp\\Excel.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {


        List<LookupWordsTO> lookupWordsTOList = new ArrayList<>();
        LookupWordsTO lookupWordsTO;

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        /*
           =============================================================
           Iterating over all the sheets in the workbook (Multiple ways)
           =============================================================
        */
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }

        /*
           ==================================================================
           Iterating over all the rows and columns in a Sheet (Multiple ways)
           ==================================================================
        */
        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 2. Or you can use a for-each loop to iterate over the rows and columns
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row: sheet) {
            // single row
            System.out.println();
            lookupWordsTO = new LookupWordsTO();
            int z = 0;
            for(Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
                z++;
                if (z==1) lookupWordsTO.setZielKategorie(cellValue);
                else if (z==2) lookupWordsTO.setZielName(cellValue);
                else if (z==3) lookupWordsTO.setW1(cellValue);
                else if (z==4) lookupWordsTO.setW2(cellValue);
                else if (z==5) lookupWordsTO.setW3(cellValue);
                else if (z==6) lookupWordsTO.setW4(cellValue);
            }
            lookupWordsTOList.add(lookupWordsTO);
        }
        System.out.println(lookupWordsTOList.size());

        // Closing the workbook
        workbook.close();
    }
}