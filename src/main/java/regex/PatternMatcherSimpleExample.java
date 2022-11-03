package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherSimpleExample {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[a-z]+");
		String text = "Now is the time";
		Matcher m = p.matcher(text);
		
		boolean flag1 = m.matches();
		boolean flag2 = m.lookingAt();
		System.out.println(flag1 + " " + flag2);
		
		while (m.find()) {
			String s = text.substring(m.start(), m.end());
			System.out.println("Found: " + s);
		}
	}
}
