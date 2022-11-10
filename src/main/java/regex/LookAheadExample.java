package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookAheadExample {
    public static void main(String[] args) {
       applyPositiveLookahead();
       checkPassword("smith4J$");
    }

    public static void applyPositiveLookahead() {
        Pattern p = Pattern.compile("a(?=b)");
        Matcher m = p.matcher("ab");
         if (m.find()) {
            System.out.println("Valid");
            //System.out.println(m.start() + " " + m.end());
        }
        else {
            System.out.println("Invalid password");
        }
    }

    public static void checkPassword(String passwd) {
        String regex = "(?=.*[A-Z])(?=.*\\d)"; // has an uppercase letter and a digit
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(passwd);
        if (matcher.find()) {
            System.out.println("Valid password");
        }
        else {
            System.out.println("Invalid password");
        }
    }


}
