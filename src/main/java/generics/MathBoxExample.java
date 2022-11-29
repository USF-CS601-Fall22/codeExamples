package generics;
import java.util.*;

public class MathBoxExample {
	public static void main(String[] args) {
		MathBox<Integer> iBox = new MathBox<>(5);
		Integer v = iBox.getData();
		iBox.setData(17);
		System.out.println(v);

		//MathBox<Number> nBox = new MathBox<Integer>(4); // won't compile - no upcasting!

		MathBox<?> numBox = new MathBox<Integer>(31); // ok
		MathBox<?> numBox1 = new MathBox<Float>(0.5f); // ok
		numBox = numBox1; // ok
		Object o = numBox.getData(); // ok
		System.out.println(numBox.sqrt()); // ok
		// still can not setData!
		// System.out.println(numBox.setData(1.7f)); // will not compile!

		/*
		MathBox<? extends Number> nBox = new MathBox<Integer>(31);
		System.out.println(nBox.getData());
		System.out.println(nBox.sqrt());
		*/
		// still can not call setData

		MathBox<? super Integer> numBox2 = new MathBox<Integer>(31);
		numBox2.setData(5);
		System.out.println(numBox2.getData());

	}
}
