package generics;

public class Max {
	
	/** This is *not* a parameterized method. 
	 * It's a regular method that takes references of Comparable type 
	 * as a parameter. is not a good practice!
	 * @param e1
	 *        The first element to compare
	 * @param e2
	 *        The second element to compare
	 * @returns The largest of the two elements (according to how compareTo is implemented)
	 */
	public static Comparable findMax(Comparable e1, Comparable e2) {
		if (e1.compareTo(e2) < 0)
			return e2;
		else
			return e1;
	}
	
	public static void main(String[] args) {

		System.out.println(Max.findMax("hello", "bye"));
		System.out.println(Max.findMax(new Circle (4.5), new Circle (8)));
		
		// The code below compiles. Crashes at runtime since it can't compare  a string with an integer. 
		// We would like to catch these types of errors at compile time.
		//System.out.println(Max.findMax("Star Wars", 3));
				
	}
	
}
