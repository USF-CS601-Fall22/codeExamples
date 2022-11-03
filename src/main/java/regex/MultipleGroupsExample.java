package regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
/** Example from: http://tutorials.jenkov.com/java-regex/matcher.html */

public class MultipleGroupsExample {

	public static void main(String[] args) {

		String text = "John writes about this, and John Doe writes about that, and John Wayne writes about everything.";
		
		String patternString1 = "(John) (.+)[,\\.]";
		//String patternString1 = "(John) (.+?)[,\\.]"; // reluctant quantifier
		//String patternString1 = "(John) (.+?) "; // try this one too to see what it will do

		Pattern pattern = Pattern.compile(patternString1);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Found:");
			System.out.println("group 1: " + matcher.group(1));
			System.out.println("group 2: " + matcher.group(2));
			System.out.println("");

		}
		
		


	}
}
