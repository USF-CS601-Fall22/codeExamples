package designPatterns.singleton;

/** A good implementation of a Singleton pattern.
 * This implementation is thread-safe.
 * See other implementations in lecture slides.
 * From Joshua Bolch, Effective Java.
 *
 */
public class Singleton {
    private static Singleton instance = new Singleton(); // created when the class is loaded

    /**
     * Constructor is made private so that client cannot create instances
     */
    private Singleton() {}

    /** No synchronization needed, since instance exists, so all threads are just reading
     *
     * @return instance of singleton
     */
    public static Singleton getInstance() {
        return instance;
    }
}

