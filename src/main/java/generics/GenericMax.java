package generics;

import java.util.Iterator;

public class GenericMax {


	/** A parameterized method to compute the maximum of two values */
	public static <E extends Comparable<E>> E findMax(E e1, E e2) {
		if (e1.compareTo(e2) < 0)
			return e2;
		else
			return e1;

	}
	
	/** A parameterized method to compute the maximum in the array of values */
	public static <E extends Comparable<E>> E findMax(E[] array) {
		E maxElem = array[0];
		for (int i = 1 ; i < array.length; i++) {
			if (array[i].compareTo(maxElem) > 0)
				maxElem = array[i];
		}
		return maxElem;

	}

	public static void main(String[] args) {
		// can call on Strings
		System.out.println(GenericMax.findMax("Star Wars", "The Lord of the Rings"));

		// can call on Circles - since class Circle implements Comparable
		System.out.println(GenericMax.findMax(new Circle(4.5), new Circle(8)));

		// With this parameterized findMax method, we can catch the error below
		// at compile time!
		// System.out.println(GenericMax.findMax( 4, "hi"));
	}
}
