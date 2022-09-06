package dependencyInjection;

import java.util.ArrayList;
import java.util.List;

// A part of the Dependency Injection example. See interfaces SpellChecker and Dictionary,
// and classes MySpellChecker, EnglishDictionary, SpanishDictionary
// Modified from the example in Effective Java book
public class EnglishDictionary implements Dictionary {
    @Override
    public boolean isValid(String word) {
        // some code here
        return false;
    }

    @Override
    public List<String> suggest(String typo) {
        List<String> list = new ArrayList<>();
        // some code here - not shown

        return list;
    }
}
