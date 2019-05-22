import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        String pathName = "IdeaProjects/TextProcessing/The_Last_of_the_Mohicans-James_Fenimore_Cooper.txt";

        /**
         * Ex. 1:
         */

        Map<String, Integer> wordCounter = new HashMap<>();
        Scanner s = new Scanner(new File(pathName));
        while (s.hasNext()) {
            String next = s.next();
            Integer count = wordCounter.get(next);
            if (count != null) {
                wordCounter.put(next, count + 1);
            } else {
                wordCounter.put(next, 1);
            }
        }
        s.close();


        System.out.println(wordCounter.entrySet());
        for (int i = 0; i < 10; i++) {
            System.out.println("-----------------------------------------");
        }
        /**
         * Ex. 3:
         */

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

        List<Character> alphabet = new ArrayList<>();
        List<String> words = new ArrayList<>();
        for (Character c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
        System.out.println(alphabet);
        s = new Scanner(new File(pathName));

        while (s.hasNext()) {
            String next = s.next();
            words.add(next);

            if (next.startsWith("'") || next.endsWith("'") || next.endsWith(",") || next.endsWith(".")) {
                next = next.replace("'", "");
                next = next.replace(".", "");
                next = next.replace(",", "");
            }
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
        s.close();
        System.out.println(wordCounter.entrySet());
        System.out.println(words);


    }
}

