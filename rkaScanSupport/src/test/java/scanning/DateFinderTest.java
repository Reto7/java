package scanning;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;


public class DateFinderTest {
//
//    @Test
//    public void testDateFinder() {
//        Parser parser=new Parser();
//        List<LocalDateModel> dates=parser.parse("Identified date :'2015-January-10 18:00:01.704', converted");
//        //System.out.println(dates);
//        //System.out.println(dates.toString());
//        System.out.println(dates.get(0).getDateTimeString());
//    }
//
//    @Test
//    public void testDateFinder2() {
//        Parser parser=new Parser();
//        List<LocalDateModel> dates=parser.parse("Identified date 31. Januar 2018");
//        //System.out.println(dates);
//        //System.out.println(dates.toString());
//        System.out.println(dates.get(0).getDateTimeString());
//    }

    @Test
    public void testDateFinder3() {
            String input = "coming from the 11/25/2009 to the 11/30/2009";
            String[] elements = input.split(" ");
            DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/uuuu");
            List<LocalDate> dates = new ArrayList<>();
            for (String element : elements) {
                try {
                    LocalDate ld = LocalDate.parse(element, f);
                    dates.add(ld);
                } catch (DateTimeParseException e) {
                    // Ignore the exception. Move on to next element.
                }
            }
            System.out.println( "dates: " + dates ) ;
        }

    @Test
    public void testDateFinder4() {
        String input = "coming from the 01.12.1988 to the 12.01.2000";
        String[] elements = input.split(" ");
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        List<LocalDate> dates = new ArrayList<>();
        for (String element : elements) {
            try {
                LocalDate ld = LocalDate.parse(element, f);
                dates.add(ld);
            } catch (DateTimeParseException e) {
                // Ignore the exception. Move on to next element.
            }
        }
      //List[] dateList = new List[]{dates};
        Collections.sort(dates, Collections.reverseOrder());
        System.out.println(dates);
    }
}


