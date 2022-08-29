package dataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/** Simple example of using a hash map to store word frequencies */
public class HashMapExample {
    /**
     *     Compute the # of occurrences for each word in the array of words
     *     @param words - an array of strings
    */
     public static void computeFrequencies(String[] words) {
        Map<String, Integer> counterMap = new HashMap<>();
        for (String word: words) {
            if (counterMap.containsKey(word)) {
                int count  = counterMap.get(word);
                counterMap.put(word, count + 1);
            }
            else { // first time we are seeing this word
                counterMap.put(word, 1);
            }
        }

        for (String word: counterMap.keySet()) {
            System.out.println(word + ": " + counterMap.get(word));
        }

    }

    /**
     * Computes a map where the lengths are the keys, and the set of words that have this length is the value.
     * @param words array of strings
     */
    public static void computeLengthToWords(String[] words) {
        HashMap<Integer, HashSet<String>> lengthToWords = new HashMap<>();
        // the key is the length of a stirng, the value  - a set of words that have this length
        for (String word: words) {
            int length = word.length();
            if (!lengthToWords.containsKey(length)) {
                lengthToWords.put(length, new HashSet<>());
            }
            HashSet<String> set = lengthToWords.get(length);
            set.add(word);
            // Or we could have just written the following instead:
            // lengthToWords.get(length).add(word);
        }

        System.out.println(lengthToWords);

    }
    public static void main(String[] args) {
        String[] words = { "cat", "dog", "cat", "bird", "elephant", "monkey", "dog", "bull" };
        System.out.println("Frequencies: ");
        computeFrequencies(words);
        System.out.println(System.lineSeparator() + "Length to words: ");
        computeLengthToWords(words);
    }

}
