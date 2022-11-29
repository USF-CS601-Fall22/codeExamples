package generics;

import java.util.*;
/** An example of a parameterized class Box
 *  mentioned in the lecture notes (courtesy of Anupam Chanda)
 */
public class Box<T> {
	private T data;

	public Box(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public static void main(String[] args) {
		// A box that stores Integers
		Box<Integer> intBox = new Box<>(15);
		Integer n = intBox.getData(); //no casting needed

		// A box that stores Strings
		Box<String> strBox = new Box<>("Alice");
		String s = strBox.getData();

		// The following errors will be caught by compiler
		// String str = (String)intBox.getData();
		// int y = (Integer)strBox.getData();
		// intBox = strBox;

		// Generics and Inheritance
		// Although Object is a superclass of String, Box<Object> is not a superclass of Box<String> !
		// Box<Object> box = new Box<String>("hello");
		//System.out.println(box.getData());

		//Object o = new Box<String>("hello"); // this is fine. Object is still a superclass.
		//System.out.println();


		// Let's play with wildcards
		//Box<? extends Integer> b1 = new Box<Integer>(31); // valid
		//b1.setData(75);
		//Integer i = b1.getData();

		//ArrayList<?> list = new ArrayList<String>();
		//Object p1 = list.get(0);

		//Box<?> b2 = new Box<String>("Hi"); // valid
		//b1 = b2; // valid


		//ArrayList<?> arr = new ArrayList<String>();


	}
}
