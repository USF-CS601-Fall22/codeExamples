package reflection;

import org.junit.*;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/** Tests for class Student. Shows one approach to testing private methods. */
public class StudentTest {

    @Test
    public void testToString() {
        Student st = new Student("Helen Chen");
        String expected = "Student: " + System.lineSeparator() + "First name: Helen";
        assertEquals("toString() fails for input Helen Chen", expected, st.toString());
    }

    @Test
    public void getFirstName() {
        Student st = new Student("Helen Chen");
        String expected = "Helen";
        try {
            Class student = Student.class;
            Method method = student.getDeclaredMethod("getFirstName", null);
            method.setAccessible(true);

            String result = (String)(method.invoke(st, null));
            //System.out.println(result);
            assertEquals("getFirstName() fails for input Helen Chen", expected, result);

        }
        catch (NoSuchMethodException e) {
            System.out.println("The method does not exist: " + e);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }



}

