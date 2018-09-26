import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class LookupWords {

  //private static final Logger logger = LoggerFactory.getLogger(WealthAdvisoryTestData.class);
    private static final String LOOKUP_WORDS_JSON = "LookupWords.json";

    private List<LookupWordsTO> LookupWordsTOList;


    public List<LookupWordsTO> buildFromFile(String filename){
        String jsonString = getFile(filename);
        List<LookupWordsTO> LookupWordsTOList = buildFromString(jsonString);
        this.LookupWordsTOList = LookupWordsTOList;
        return LookupWordsTOList;
    }

    public List<LookupWordsTO> buildFromString(String jsonString){
        List<LookupWordsTO> LookupWordsTOList = convertJsonToJavaBeanTestDataTO(jsonString);
        for (LookupWordsTO LookupWordsTO : LookupWordsTOList){
            LookupWordsTO.validate();
        }
        this.LookupWordsTOList = LookupWordsTOList;
        return LookupWordsTOList;
    }


    private List<LookupWordsTO> convertJsonToJavaBeanTestDataTO(String jsonString) {
        Type listType = new TypeToken<List<LookupWordsTO>>(){}.getType();
        List<LookupWordsTO> LookupWordsTOList = new Gson().fromJson(jsonString, listType);
        return LookupWordsTOList;
    }

    private String getFile(String fileName)  {
        StringBuilder result = new StringBuilder("");
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public List<LookupWordsTO> getAllData(){
        return buildFromFile(LOOKUP_WORDS_JSON);
    }

}
