package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** Parameterized JUnit class */
@RunWith(Parameterized.class)
public class FactorialTest {
    private int inputN;
    private int expectedFactorialResult;

    public FactorialTest(int n, int expected) {
        this.inputN = n;
        this.expectedFactorialResult = expected;
    }

    @Test
    public void testCompute() {
        assertEquals(expectedFactorialResult, Factorial.compute(inputN));
    }

    @Parameters(name = "factorial({0}) =  {1}")
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{0, 1}); // 0 is n, 1 is factorial(n)
        inputExpectedList.add(new Object[]{1, 1});
        inputExpectedList.add(new Object[]{2, 2});
        inputExpectedList.add(new Object[]{3, 6});
        inputExpectedList.add(new Object[]{4, 24});
        return inputExpectedList;

    }
}