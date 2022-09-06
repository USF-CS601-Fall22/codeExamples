package inheritance;

/** The example demonstrates that static methods do hot behave polymorphically. */
public class OverridingExample {
    public static void main(String[] args) {
        Superclass super1 = new Superclass();
        Superclass sub1 = new Subclass();
        Subclass sub2 = new Subclass();

        //super1.func1(); // parent's version
        sub1.func1(); // child's version
        //sub2.func1(); // child's version


        System.out.println();
        //Superclass.staticFunc1(); // parent's version
        //super1.staticFunc1(); // parent's version
        // sub1.staticFunc1(); // parent's version - for static methods, binding happens at compile time, based on the type of reference; In this case, reference is of type Superclass
        //sub2.staticFunc1(); // child's version, since the type of sub2 is a Subclass
        // sub1.func1(); // call staticFunc1 from inside of func1 in Subclass and see what happens
        // sub2.func1();
    }
}
