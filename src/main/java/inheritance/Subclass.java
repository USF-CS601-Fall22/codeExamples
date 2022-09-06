package inheritance;

/** The example demonstrates that static methods do hot behave polymorphically. */
public class Subclass  extends Superclass {

    /** Subclass overrides non-static method of the superclass */
    @Override
    public void func1() {
        System.out.println("func1, subclass version");
        // staticFunc1();
    }

    /** Subclass cannot override the static method of the parent, but it
     * can provide it's own static method with the same name. It will not behave polymorphically.
      */
    public static void staticFunc1() {
        System.out.println("staticFunc1, subclass version");
    }
}
