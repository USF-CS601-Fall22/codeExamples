package reflection;

import java.lang.reflect.InvocationTargetException;

public class ReflectionExample {
    public static Object createObject(String classname, String argValue) {
        Object o = null;
        try {
            Class objectClass = Class.forName(classname);
            Class[] arguments = new Class[1];
            arguments[0] = String.class;
            o = objectClass.getDeclaredConstructor(arguments).newInstance(argValue);


        }
        catch (ClassNotFoundException e) {
            System.out.println("No such class: " + classname);
        }
        catch (NoSuchMethodException e) {
            System.out.println("No constructor in class: " + classname);
        }
        catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            System.out.println("Cannot create an object of this class: " + classname);
        }
        return o;

    }

    public static void main(String[] args) {
        Object o  = createObject("university.Student", "Helen");
        System.out.println(o);
    }
}
