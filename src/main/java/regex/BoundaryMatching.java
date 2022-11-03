package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Shows how to use boundary matchers. Based on following example:
 * https://docs.oracle.com/javase/tutorial/essential/regex/bounds.html
 */
public class BoundaryMatching {

    public static void printMatches(String name, String regex, String text) {
        Pattern regexPattern = Pattern.compile(regex);
        Matcher matcher = regexPattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Matcher " + name + ": I found the text: " + text.substring(matcher.start(), matcher.end()));
        }

    }

    public static void main(String[] args) {
        printMatches("1", "^dog$", "dog" ); // needs to start at the beginning of the line
        // and end
        printMatches("2", "^dog$", "doggie");

        printMatches("3", "^dog\\w*$", "doggie");

        printMatches("4", "\\bdog\\b", "The dog ran outside with the doggie and suddenly,dog showed up.");

    }
}
