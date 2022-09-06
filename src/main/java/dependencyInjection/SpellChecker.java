package dependencyInjection;

import java.util.List;

public interface SpellChecker {
    boolean checkSpelling(String word);
    List<String> correctSpelling(String wordWithTypo);
    void setDictionary(Dictionary d);

}
