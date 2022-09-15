package inheritance.creatureAlienExercise;

/** From the book : Java 1.4 Game programming.
 *  Represents an Alien, a subclass of Creature.
 *  Overrides speak() method to say: Alien from planet <nameOfPlanet> says <greeting>
 *  where the greeting is from the parent's class Creature.
 *  Has a fight() method that is not in the parent class.
 *
 *  */
public class Alien { // FILL IN CODE: Alien should be a subclass of Creature
    private String planet; // the name of the planet where the alien lives
    private static int numAliensFromMars = 0; // the number of aliens from Mars

    public Alien(String greeting, String planet) {
        // FILL IN CODE to initialize greeting and planet
        // How will you initialize greeting if it's private in the parent class Creature?

        // Also, if the planet is Mars, increment numAliensFromMars to keep track of all aliens from Mars
    }

    // FILL IN CODE
    // Override the speak method so that the alien says:
    // Alien from such and such planet says greeting


    public void fight() {
        // If this alien is not from Mars, do nothing
        // If this alien is from Mars and the total number of aliens from Mars is greater than 3, then
        // print "Let's fight!");
        // If this alien is from Mars, but the total number of aliens from Mars is <=3, then
        // do nothing
        // FILL IN CODE

    }

}
