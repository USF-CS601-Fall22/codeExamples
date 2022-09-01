package cohesion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/** A HelperClass class has several unrelated methods.
 * An example of a low cohesion class - this is a very poor design.
 *
 */
public class HelperClass {
	private String filename;
	private List<String> strings;

	public HelperClass(String filename, List<String> strings) {
		this.filename = filename;
		this.strings = strings;
	}

	public String concatenateStrings() {
		if (strings == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (String s: strings) {
			if (s != null)
				sb.append(s + " ");
		}
		return sb.toString();
	}

	public void readFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch (IOException e) {
			System.out.println("Cannot read from the file " + e);
		}

	}


}
