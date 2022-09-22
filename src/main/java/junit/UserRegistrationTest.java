package junit;


import static org.junit.Assert.*;

import org.junit.Test;

/** Tests for the validateUsername method of class UserRegistration.
 *  Note that the tests below do not cover all the edge cases that need to be tested.
 *  This example is meant to show you how to write simple JUnit tests. 
 */
// you should test. They are just simple examples to demonstrate how to write
// JUnit tests
public class UserRegistrationTest {

	@Test(expected = IllegalArgumentException.class)
	public void validateUsernameNull() {
		UserRegistration.validateUsername(null);
	}

	@Test
	public void validateUsernameEmptyString() {
		assertFalse(UserRegistration.validateUsername(""));
	}
	
	@Test
	public void validateUsernameTooLong() {
		assertFalse(UserRegistration.validateUsername("iChose9_TheLongestUsernameICouldThinkOf"));
	}

	@Test
	public void validateUsernameTooShort() {
		assertFalse(UserRegistration.validateUsername("ssh"));
	}

	@Test
	public void validateUsernameNoUnderscore() {
		assertFalse(UserRegistration.validateUsername("tiTani6c"));
	}
	
	@Test
	public void validateUsernameNoDigit() {
		assertFalse(UserRegistration.validateUsername("user_Name"));
	}
	
	@Test
	public void validateUsernameFirstCharNotLowerCase() {
		assertFalse(UserRegistration.validateUsername("User_Name7"));
	}

	@Test
	public void validateUsernameValidName() {
		assertTrue(UserRegistration.validateUsername("user_01"));
	}

	
}
