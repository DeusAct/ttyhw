import java.io.File;
import java.io.IOException;
import java.util.*;

public class Exercises {

    String pathName = "IdeaProjects/TextProcessing/The_Last_of_the_Mohicans-James_Fenimore_Cooper.txt";

    public void exerciseOne() throws IOException {

        /**
         * Ex. 1:
         */

        Map<String, Integer> wordCounter = new HashMap<>();
        Scanner s = new Scanner(new File(pathName));
        while (s.hasNext()) {
            String next = s.next();
            wordCounter.merge(next, 1, (a, b) -> a + b);
            formatString(next);

        }
        printHashKeys(wordCounter, s);


        for (int i = 0; i < 10; i++) {
            System.out.println("-----------------------------------------");
        }


        /**
         * Ex. 3:
         */

        System.out.println(" ");
        System.out.println("Unique values: ");
        System.out.println(" ");

        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (value == 1) {
                System.out.println(key);
            }
        }
        wordCounter.clear();

        /**
         * Ex. 2:
         */

        for (int i = 0; i < 10; i++) {
            System.out.println("-----------------------------------------");
        }

        System.out.println(" ");
        System.out.println("How many words begin with each letter: ");
        System.out.println(" ");

        List<Character> alphabet = new ArrayList<>();
        List<String> words = new ArrayList<>();
        for (Character c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }

        s = new Scanner(new File(pathName));

        while (s.hasNext()) {
            String next = s.next();
            words.add(next);

            next = formatString(next);
            for (Character letter : alphabet) {
                if (next.toLowerCase().startsWith(String.valueOf(letter))) {
                    if (wordCounter.containsKey(String.valueOf(letter))) {
                        wordCounter.put(String.valueOf(letter), wordCounter.get(String.valueOf(letter)) + 1);
                    } else {
                        wordCounter.put(String.valueOf(letter), 1);
                    }
                }
            }
        }
        printHashKeys(wordCounter, s);
    }

    private void printHashKeys(Map<String, Integer> wordCounter, Scanner s) {
        s.close();

        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("Key: " + key + "," + " Value: " + value);
        }
    }

    private String formatString(String next) {
        if (next.startsWith("'") || next.endsWith("'") || next.endsWith(",") || next.endsWith(".")) {
            next = next.replace("'", "");
            next = next.replace(".", "");
            next = next.replace(",", "");
        }
        return next;
    }

    }
