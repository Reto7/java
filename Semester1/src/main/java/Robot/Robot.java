package Robot;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

import java.util.ArrayList;

public class Robot {

    /**
     * The first time you boot them up, a random name is generated in the format of two uppercase letters
     * followed by three digits, such as RX837 or BC811.
     * Every once in a while we need to reset a robot to its factory settings, which means that their
     * name gets wiped. The next time you ask (getName), it will respond with a new random name.
     * Robots need to have a unique name.
     */

    private static ArrayList<String> listOfUsedRobotNames = new ArrayList<>();
    private String name;

    public Robot() {
        setName(generateNewValidName());
    }

    public String getName() {
        if (this.name != null) {
            return name;
        }
        else {
            setName(generateNewValidName());
            return name;
        }
    }

    private void setName(String name) {
        this.name = name;
        listOfUsedRobotNames.add(name);
    }

    public void reset() {
        this.name = null;
    }

    private String generateNewValidName(){
        String newRandomName;
        do {
            newRandomName = generateRandomNameString();
        } while (listOfUsedRobotNames.contains(newRandomName));
        return newRandomName;
    }

    private static String generateRandomNameString() {
        String randomString;

        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('A', 'Z')
                        .filteredBy(CharacterPredicates.LETTERS)
                        .build();
        randomString = randomStringGenerator.generate(2).toUpperCase();

        randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('0', '9')
                        .filteredBy(CharacterPredicates.DIGITS)
                        .build();
        randomString += randomStringGenerator.generate(3);

        return randomString;
    }

}
