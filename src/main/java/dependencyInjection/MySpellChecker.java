package dependencyInjection;

import java.util.List;
// A part of the Dependency Injection example. See interfaces SpellChecker and Dictionary,
// and classes MySpellChecker, EnglishDictionary, SpanishDictionary
// Modified from the example in Effective Java book
public class MySpellChecker implements SpellChecker {

    private Dictionary dictionary;

    public MySpellChecker(Dictionary dictionary) {

        this.dictionary = dictionary;
    }

    @Override
    public boolean checkSpelling(String word) {
        return dictionary.isValid(word);
    }

    @Override
    public List<String> correctSpelling(String wordWithTypo) {
        //  maybe add some filtering of suggestions
        return dictionary.suggest(wordWithTypo);
    }

    public void setDictionary(Dictionary dict) {
        this.dictionary = dict;
    }
}
