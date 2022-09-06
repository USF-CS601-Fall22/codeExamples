package interfaces;

public class CreatureExample {
    public static void main(String[] args) {
        /*Creature s = new Creature();
        // s.say("Hi");
        s.shout(); */

        Speak s = new Creature();
        s.say("Hello");
        s.shout();

    }
}
