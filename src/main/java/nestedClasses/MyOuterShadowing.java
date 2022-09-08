package nestedClasses;

/** Another example of an inner class enclosed by outer class.
 *  Demonstrates shadowing. */
public class MyOuterShadowing {
    int x = 2; // instance variable in the outer class
    int y = 8;
    /* Inner class, MyInner */
    class MyInnerShadowing {
        int x = 6;

        private void printVars() {
            int x = 8;
            System.out.println( x ); // 8  referring to the local variable x
            System.out.println(y);
            System.out.println( this.x ); //6  referring to the instance variable of MyInnerWithShadowing
            System.out.println( MyOuterShadowing.this.x ); //2  referring to the instance variable of MyOuterWithShadowing
        }
    }

    public void printX() {
        System.out.println("Outer method printX: " + x);
    }

    public static void main(String[] args) {
        MyOuterShadowing outer = new MyOuterShadowing();
        outer.printX();
        MyInnerShadowing inner  = outer.new MyInnerShadowing();
        inner.printVars();
    }
}

