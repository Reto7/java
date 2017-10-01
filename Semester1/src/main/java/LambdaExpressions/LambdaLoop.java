package LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by user on 01.10.2017.
 */
public class LambdaLoop {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("element1","element2","element3");
        for (String element : myList) {
            System.out.println (element);
        }

        //Iterable Interface in Java 8 um die Methode forEach erweitert. Damit wird das folgende Konstrukt möglich,
        //ist aber unuebersichtlich und noch laenger als der Code oben
        myList.forEach(new Consumer<String>() {
            public void accept(String element) {
                System.out.println(element);
            }
        });

        // LAMBDA
        myList.forEach((String element) -> System.out.println(element));
        // oder noch einfacher:
        myList.forEach(element -> System.out.println(element));
    }

}
