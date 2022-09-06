package inheritance;

/** From the book : Java 1.4 Game programming 
 * A super class. Represents some intelligent life form that can talk.
 */
public class Creature {
	private String greeting;

	public Creature(String greeting) {
		this.greeting = greeting;
	}

	public void setGreeting(String s) {
		greeting = s;
	}

	public String getGreeting() {
		return greeting;
	}

	public void speak() {
		System.out.println("Creature says: " + greeting);
	}

	private void func() {
		System.out.println("private");
	}
}
