package dependencyInjection;

import java.util.List;
// A part of the Dependency Injection example. See interfaces SpellChecker and Dictionary,
// and classes MySpellChecker, EnglishDictionary, SpanishDictionary
// Modified from the example in Effective Java book
public class DependencyInjectionExample {
    public static void main(String[] args) {
        Dictionary dictionary = new EnglishDictionary();
        SpellChecker checker = new MySpellChecker(dictionary);
        System.out.println(checker.checkSpelling("profesor"));
        List<String> suggestions  = checker.correctSpelling("profesor");
        System.out.println(suggestions); // note: currently won't return anything, since the method is not implemented

        dictionary = new SpanishDictionary();
        checker.setDictionary(dictionary);
        System.out.println(checker.correctSpelling("hola")); // again, currently won't do anything
    }
}
