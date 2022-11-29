package generics;

/** A parameterized class that uses bounded parameterized types.
 *  Courtesy of Anupam Chanda.
 */
public class MathBox<T extends Number> {
	private T data;

	public MathBox(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public double sqrt() {
		return Math.sqrt(getData().doubleValue());
	}
}
