package inheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * The Example that demonstrates overriding, upcasting, downcasting and polymorphism. 
 * Tests classes Creature, Human and Alien
 */

public class Driver {
	public static void main(String[] args) {

		List<Creature> creatures = new ArrayList<Creature>();
		Creature alien1 = new Alien("dak-dak", "Mars");
		Creature human1 = new Human("Enrique", "Hola!");
		Creature alien2 = new Alien("ioioio", "Mars");
		Creature human2 = new Human("Taylor", "Hello!");
		//Creature alien3 = new Alien("hgoohs", "Mars");
		creatures.add(alien1);
		creatures.add(human1);
		creatures.add(alien2);
		creatures.add(human2);
		//creatures.add(alien3);

		// Iterate over the ArrayList, call speak() method for
		// each creature. Call fight() for each Alien
		for (Creature creature : creatures) {
			creature.speak(); // different speak() method will be invoked,
								// depending on what object the creature is referencing
			// If the creature is an alien, call the fight() method
			if (creature instanceof Alien) {
				((Alien) creature).fight();
			}
		}



	}

}
