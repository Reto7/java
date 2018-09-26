import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class LookupWords {

    //private static final Logger logger = LoggerFactory.getLogger(WealthAdvisoryTestData.class);
//    private static final String LOOKUP_WORDS_JSON = "LookupWords.json";
//    private List<LookupWordsTO> LookupWordsTOList;


    public static List<LookupWordsTO> buildFromFile(){
        String jsonString = null;
        try {
            jsonString = getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<LookupWordsTO> LookupWordsTOList = buildFromString(jsonString);
//        this.LookupWordsTOList = LookupWordsTOList;
        return LookupWordsTOList;
    }

    public static List<LookupWordsTO> buildFromString(String jsonString){
        List<LookupWordsTO> LookupWordsTOList = convertJsonToJavaBeanTestDataTO(jsonString);
        for (LookupWordsTO LookupWordsTO : LookupWordsTOList){
            LookupWordsTO.validate();
        }
//        this.LookupWordsTOList = LookupWordsTOList;
        return LookupWordsTOList;
    }


    private static List<LookupWordsTO> convertJsonToJavaBeanTestDataTO(String jsonString) {
        Type listType = new TypeToken<List<LookupWordsTO>>(){}.getType();
        List<LookupWordsTO> LookupWordsTOList = new Gson().fromJson(jsonString, listType);
        return LookupWordsTOList;
    }

    private static String getFile() throws IOException {
        // TODO auf h:
        Scanner in = new Scanner(new FileReader("/home/rk/IntelliJ-Workspace/rkaScanSupport/src/main/resources/LookupWords.json"));
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        return sb.toString();
    }

//    private String getFile(String fileName)  {
//        StringBuilder result = new StringBuilder("");
//        //Get file from resources folder
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource(fileName).getFile());
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                result.append(line).append("\n");
//            }
//            scanner.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result.toString();
//    }

    public List<LookupWordsTO> getAllData(){
        return buildFromFile();
    }

}
