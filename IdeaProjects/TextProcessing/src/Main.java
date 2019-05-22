import java.io.*;
import java.util.*;

public class Main {

    //public static void main(String[] args) throws IOException {

    //        List<String> list = Files.readAllLines(Paths.get("The_Last_of_the_Mohicans-James_Fenimore_Cooper.txt"));
//
//
//        Set<String> unique = new HashSet<>(list);
//        for (String key : unique) {
//            System.out.println(key + ": " + Collections.frequency(list, key));
//        }

    public static void main(String[] args) throws IOException {


        Map <String, Integer> wordCounter = new HashMap<>();
        Scanner s = new Scanner(new File("The_Last_of_the_Mohicans-James_Fenimore_Cooper.txt"));
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

//        Map <String, Integer> wordCounter = new HashMap<>();
//        Scanner s = new Scanner(new File("The_Last_of_the_Mohicans-James_Fenimore_Cooper.txt"));
//        while (s.hasNext()) {
//            String next = s.next();
//            Integer count = wordCounter.get(next);
//            if (count != null) {
//                wordCounter.put(next, 1);
//            } else {
//                wordCounter.put(next, 0);
//            }
//        }
//        s.close();

        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println ("Key: " + key + "," + " Value: " + value);
        }

        System.out.println(" ");
        for (int i=0; i<10; i++){
            System.out.println("-----------------------------------------");
        }

        System.out.println("Unique values: ");
        System.out.println(" ");

        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if(value == 1) {
                System.out.println(key);
            }
        }
    }
}

