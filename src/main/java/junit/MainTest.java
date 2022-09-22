package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/** Test Suite allows us to run multiple tests together (build a suite from multiple test classes) */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        StringUtilTest.class,
        UserRegistrationTest.class,
        FactorialTest.class
})
public class MainTest {
    // Nothing here, just "coordinates" the work of two other testers
}
