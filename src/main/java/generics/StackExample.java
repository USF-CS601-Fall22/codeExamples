package generics;

/** Shows how to use the parameterized class Stack.  */

public class StackExample {
	
	public static void main(String[] args) {
		System.out.println("A stack of strings: ");
		Stack<String> stackStr = new Stack<>(20);
		stackStr.push("one");
		stackStr.push("two");
		stackStr.push("three");
		stackStr.print();
		System.out.println(stackStr.pop());
	
		System.out.println("A stack of integers: ");
		Stack<Integer> stackInt = new Stack<>(4);
		stackInt.push(5);
		stackInt.push(15);
		stackInt.push(53);
		stackInt.print();
		
		// testing methods from StackUtil class:
		StackUtil.emptyStack(stackInt);


		Stack<Integer> reversed = StackUtil.reverseStack(stackInt);
		System.out.println("After reversing: ");
		reversed.print();


		//Stack<String> reversedStr = StackUtil.reverseStack(s);
		//System.out.println("After reversing: ");
		//reversedStr.print();

	}
}
