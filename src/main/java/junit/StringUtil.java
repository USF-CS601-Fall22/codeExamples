package junit;

import java.util.Arrays;
/** A StringUtil class that has some methods to manipulate strings. 
 * The goal of this simple example is to show you how to write basic JUnit tests.
 */
public class StringUtil {

	public static String trimConcatenate(String s1, String s2) {
		if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() )
			throw new IllegalArgumentException();
		return s1.trim() + s2.trim();
	}

	public static String[] splitByCommas(String s) {
		assert(s != null);
		String[] words = s.split(",");
		return words;
	}

   // more methods for string manipulation can be added here..
	public static void main(String[] args) {
		System.out.println(StringUtil.trimConcatenate("Halloween  ", "pumpkin "));
		System.out.println(StringUtil.trimConcatenate("Do or do not,     there is no try  ", "."));

		String[] words = StringUtil.splitByCommas("This is a new day, a new beginning");
		System.out.println(Arrays.toString(words));
	}
}
