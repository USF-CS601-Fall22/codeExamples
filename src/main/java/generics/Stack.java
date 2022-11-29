package generics;
/** A parameterized class Stack. From Deitel&Deitel, Java How to program. */

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	final static int MIN_CAPACITY = 10;
	private int capacity = 0;
	
	private List<T> elems; // ArrayList will be used to represent a stack

	public Stack(int capacity) {
		if (capacity < MIN_CAPACITY)
			capacity = MIN_CAPACITY;
		elems = new ArrayList<T>(capacity);
	}

	public void push(T elem) {
		elems.add(elem);
	}

	public T pop() {
		if (elems.isEmpty()) {
			System.out.println("No elements to pop");
			return null;
		}
		return elems.remove(elems.size() - 1);
	}

	public boolean isEmpty() {
		return (elems.size() == 0);
	}

	public int getCapacity() {
		return capacity;
	}
	
	public void print() {
		if (isEmpty())
			System.out.println("The stack is empty, nothing to print.");
		for (T elem: elems) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

}
