package servlets.sessions.dictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public void addWord(String english, String spanish) {
        dictionary.put(english, spanish);
    }

    public String translateToSpanish(String english) {
        return dictionary.get(english);
    }

}
