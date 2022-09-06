package dependencyInjection;

import java.util.ArrayList;
import java.util.List;

// Example of hardwiring - avoid doing it!
// Modified from Effective Java, Edition 3
public class SpellCheckerWithHardwiring {
    private final Lexicon dictionary = new Lexicon();
    // Other variables as needed

    public SpellCheckerWithHardwiring() {
        // something here
    }

    public boolean checkSpelling(String word) {
        return dictionary.isValid(word);
    }

    public List<String> correctSpelling(String wordWithTypo) {
        List<String> list = new ArrayList<>();
        // some code that uses dictionary's suggest method

        return list;
    }
}
