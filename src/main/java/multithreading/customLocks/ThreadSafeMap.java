package multithreading.customLocks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeMap {
    private Map<String, String> englishToSpanishMap;
    private ReentrantReadWriteLock lock;

    public ThreadSafeMap() {
        englishToSpanishMap = new HashMap<>();
        lock = new ReentrantReadWriteLock();
    }

    public String getSpanishWord(String englishWord) {

        return "";
    }

    public void addWord(String englishWord, String spanishWord) {

    }


}
