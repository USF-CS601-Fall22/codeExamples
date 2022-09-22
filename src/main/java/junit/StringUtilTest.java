package junit;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import designPatterns.mvc.simple.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/** Test class for StringUtil class.
 *  The goal of this simple example is to show you how to write basic JUnit tests. 
 *  Please note that the tests below do not cover all the edge cases you should test.
 */
public class StringUtilTest {

	@Test
	public void testTrimConcatenate() {
		String res = StringUtil.trimConcatenate(" hell  o ", " wor, ld  ");
		String expected = "hell  owor, ld";
		assertEquals("The result is not what expected", expected, res);
	}

	@Test(expected = IllegalArgumentException.class)
	public void trimConcatenateNullException1() {
		String res = StringUtil.trimConcatenate(null, "abc");

	}

	@Test
	public void trimConcatenateNullException2() {
		try {
			String res = StringUtil.trimConcatenate(null, "abc");
			fail("Error: IllegalArgumentException should have been thrown");

		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException is thrown as expected");
		} catch (Exception e) {
			fail("Unknown exception is thrown.");
		}
	}

	@Test
	public void testSplitByCommasBasic() {
		String[] res = StringUtil.splitByCommas("This is a new day, a new beginning.");
		String[] expectedArr = {"This is a new day", " a new beginning."};
		assertArrayEquals(res, expectedArr);

	}


}
