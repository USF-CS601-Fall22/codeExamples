package inheritance.staticMethods;

/** The example demonstrates that static methods do hot behave polymorphically. */
public class Superclass {
    /** Constructor */
    public Superclass() {

    }

    /** Non-static method */
    public void func1() {
        System.out.println("func1, Superclass version");
    }

    /** Static method */
    public static void staticFunc1() {
        System.out.println("staticFunc1, Superclass version");
    }
}
