package scanning;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LookupWords {

    private static final Logger logger = LoggerFactory.getLogger(LookupWords.class);
    public static final String SAMPLE_XLSX_FILE_PATH = "H:\\Dropbox\\Scan_Source\\LookupWords.xlsx";


    public static List<LookupWordsTO> buildWordList() {
        try {
            return readExcelCreateWordList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return  null;  // TODO
    }

    private static List<LookupWordsTO> readExcelCreateWordList() throws IOException, InvalidFormatException  {

        List<LookupWordsTO> lookupWordsTOList = new ArrayList<>();
        LookupWordsTO lookupWordsTO;

        logger.info("");
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
        // single row
        lookupWordsTO = new LookupWordsTO();

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
            if (lookupWordsTO.getW1()!= null) {
                if (lookupWordsTO.getW1().length()>1) {
                    lookupWordsTOList.add(lookupWordsTO);
                }
            }
        }
        System.out.println(lookupWordsTOList.size());

        // Closing the workbook
        workbook.close();

        return  lookupWordsTOList;
    }


    public List<LookupWordsTO> getAllData(){
        logger.info("");
        try {
            List<LookupWordsTO> LookupWordsTOList = readExcelCreateWordList();
            for (LookupWordsTO LookupWordsTO : LookupWordsTOList){
                LookupWordsTO.validate();
            }
            return LookupWordsTOList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return null; // TODO
    }

}
