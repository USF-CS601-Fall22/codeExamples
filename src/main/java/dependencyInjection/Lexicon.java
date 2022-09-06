package dependencyInjection;

import java.util.ArrayList;
import java.util.List;

// Example of hardwiring - avoid doing it!
// From Effective Java, Edition 3
public class Lexicon {
    public boolean isValid(String word) {
        // some implementation here - not shown

        return true;
    }

    public List<String> suggest(String typo) {
        List<String> list = new ArrayList<>();
        // some code here - not shown

        return list;
    }
    // Other methods as needed
}
