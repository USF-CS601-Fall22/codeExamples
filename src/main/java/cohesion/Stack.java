package cohesion;

/** An example of a class with high cohesion. This is a good design. */
public class Stack {
    final static int MAX_SIZE = 20;
    private Object[] data;
    private int top = 0;

    public Stack() {
        data = new Object[MAX_SIZE];
        top = 0;
    }

    public void push(Object elem) {
        if (top == MAX_SIZE)
            throw new IllegalStateException();
        data[top] = elem;
        top++;

    }
    public Object pop() {
        return data[--top];
    }
    public boolean empty() {
        return (top == 0);
    }

}
