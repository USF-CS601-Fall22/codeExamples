package dataStructures;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetExample {
    public static void main(String[] args) {

        /*HashSet<String> words = new HashSet<String>();
        words.add("cat");
        words.add("mail");
        words.add("dog");
        words.add("cat"); // won't add it again
        System.out.println(words); //don’t know the order

         */

        // If we care about sorted order
        TreeSet<String> wordsTree = new TreeSet<>();
        wordsTree.add("cat");
        wordsTree.add("mail");
        wordsTree.add("dog");
        String firstElement = wordsTree.first();
        System.out.println(firstElement);
        String test = wordsTree.lower("mail");
        System.out.println(test);

    }
}
