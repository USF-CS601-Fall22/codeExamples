package inheritance;

/**
 * From the book : Java 1.4 Game programming. Represents an Alien, a subclass of
 * Creature. Overrides speak() method to say: Alien from planet
 * <nameOfPlanet> says <getGreeting()> ! Has a fight() method that is not in the
 * superclass.
 */

public class Alien extends Creature {

	private String planet; // the name of the planet
	private static int numAliensFromMars = 0; // the number of aliens from Mars

	public Alien(String greeting, String planet) {
		super(greeting);
		this.planet = planet;
		if (planet.equals("Mars"))
			numAliensFromMars++;
	}

	@Override
	public void speak() {
		System.out.println("Alien from planet " + planet + " says: " + getGreeting() + ". ");

	}

	public void fight() {
		// If this alien is from Mars and the total number of aliens from Mars
		// is greater than 3, then
		// print "Let's fight!");
		if ((planet.equals("Mars")) && (numAliensFromMars >= 3)) {
			System.out.println("Let's fight!");
		}

	}
}
