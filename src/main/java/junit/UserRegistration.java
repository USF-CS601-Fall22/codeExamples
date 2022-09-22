package junit;


import java.security.InvalidParameterException;

/** The class that "registers" a user with the given username.
 *  Has a method to validate a given username.
 *  I believe this example was modified from the example of Pr. Engle.
 */
public class UserRegistration {
	private String username;

	public UserRegistration(String username) {
		if (validateUsername(username)) {
			this.username = username;
		} else {
			System.out.println("Not a valid user name.");
			throw new InvalidParameterException();
		}
	}

	/**
	 * Validates a given username.
	 * 
	 * @param username
	 *            username
	 * @return true if a given username is valid, false otherwise
	 */
	public static boolean validateUsername(String username) {
		// For the purpose of this example, a username is valid if:
		// 1) It consists of at least 5 characters, but no more than 20
		// 2) Starts with a lowercase character
		// 3) Contains an underscore and a digit
		if (username == null) {
			System.out.println("username is null");
			throw new IllegalArgumentException();
		}
		if (username.isEmpty())
			return false;
		int l = username.length();
		char ch = username.charAt(0);
		if (l < 5 || l > 20 || !Character.isLowerCase(ch)) {
			System.out.println("Select a username that is >=5 and <=100  letters long. "
					+ System.lineSeparator() + " Also the first character should be lowercase.");
			return false;
		}
		boolean foundDigit = false;
		boolean foundUnderscore = false;

		for (int i = 0; i < username.length(); i++) {
			if (Character.isDigit(username.charAt(i)))
				foundDigit = true;
			if ((Character.toString(username.charAt(i))).equals("_"))
				foundUnderscore = true;
		}
		return foundDigit && foundUnderscore;
	}

}
