package nestedClasses;

import dependencyInjection.EnglishDictionary;

/** Example of an inner class contained withing an outer class.  */
public class MyOuter {
    private int var; // instance variable in the outer class

    public MyOuter(int var) {
        this.var =  var;
    }

    /* Inner class, MyInner
     *  Declared with default visibility */
    class MyInner { // could make this class private, protected, default or public
        private void func() {
            System.out.println(var); // referring to outer's var variable
        }
    }

    public static void main(String[] args) {
        MyOuter outer = new MyOuter(2);
        MyInner inner  = outer.new MyInner();
        inner.func();

    }
}

