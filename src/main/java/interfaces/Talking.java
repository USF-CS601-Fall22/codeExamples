package interfaces;

/** The main class for the Speak/GameCharacter example that
 * demonstrates polymorphism via interfaces.  */
public class Talking {
    public static void main(String[] args) {
        Speaker speaker;
        speaker = new Philosopher();
        //speaker.speak();
        //speaker.pontificate();

        //((Philosopher) speaker).pontificate();

        speaker = new Dog();
        //speaker.speak();

        //Philosopher phil = new Philosopher();
        //phil.pontificate();

        //speaker = new Philosopher();





    }
}
