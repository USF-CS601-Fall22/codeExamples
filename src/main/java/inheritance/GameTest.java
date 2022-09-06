package inheritance;

import java.util.ArrayList;

/**
 * The Example that demonstrates overriding. Tests classes Creature, Human and
 * Alien
 */

public class GameTest {
	public static void main(String[] args) {

		/*Creature creature = new Creature("Hi");
		creature.speak();
		
		Creature c1 = new Alien("Dak-Dak", "Mars");
		c1.speak();
		
		
		Creature c2 = new Human("Andrew", "How are you?");
		c2.speak();
		*/
		
	
		
		ArrayList<Creature> creatures = new ArrayList<Creature>();
		Creature c = new Alien("dak-dak", "Mars");
		creatures.add(c);
		creatures.add(new Human("Enrique", "Hola!"));
		creatures.add(new Alien("ioioio", "Mars"));
		creatures.add(new Human("Taylor", "Hello!"));
		creatures.add(new Alien("hgoohs", "Mars"));

		// Iterate over the ArrayList, call speak() method for
		// each creature. Call fight() for each Alien
		//
		for (Creature creature : creatures) {
			creature.speak(); // different speak() method will be invoked,
								// depending on what object the creature is
								// referencing
			// If the creature is an alien, call the fight() method
			//if (creature instanceof Alien) {
			//	((Alien) creature).fight();
			//}
		}
	
	}

}
