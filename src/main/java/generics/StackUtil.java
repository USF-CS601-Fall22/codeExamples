package generics;

/** Shows two parameterized methods that perform operations on the parameterized stack */

public class StackUtil {
	/** A Helper method for emptying the stack
	 *  @param  stack
	 */
	public static <E> void emptyStack(Stack<E> stack) {
		while (!stack.isEmpty()) {
			stack.pop();
		}
		
	}
	
	/** Reverses the stack
	 * @param stack that needs to be reversed
	 * @returns a new stack that is the reversed version of the given stack
	 * 
	 */
	public static <E> Stack<E> reverseStack(Stack<E> stack) {
		Stack<E> reversed = new Stack<E>(stack.getCapacity());
		while (!stack.isEmpty()) {
			E elem = stack.pop(); // side effect: empty the original stack!
			reversed.push(elem);
		}
		return reversed;
	}
}
