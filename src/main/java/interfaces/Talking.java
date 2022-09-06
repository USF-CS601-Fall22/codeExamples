package interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** The main class for the Speak/GameCharacter example that
 * demonstrates polymorphism via interfaces.  */
public class Talking {
    public static void main(String[] args) {
        Speaker speaker = new Philosopher();
        speaker.speak();
        //((Philosopher) speaker).pontificate();

        speaker = new Dog();
        speaker.speak();

        //Philosopher p = new Philosopher();
        //p.pontificate();

    }
}
