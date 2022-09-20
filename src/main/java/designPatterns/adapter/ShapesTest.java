package designPatterns.adapter;
/** Modified from https://sourcemaking.com/design_patterns/adapter/java/1 */

public class ShapesTest {
	public static void main(String[] args) {
		// Without the adapter: not elegant
		Object[] shapes = { new Line(), new Rectangle() };
		int x1 = 10, y1 = 20;
		int x2 = 30, y2 = 60;
		for (int i = 0; i < shapes.length; ++i)
			if (shapes[i] instanceof Line)
				((Line) shapes[i]).draw(x1, y1, x2, y2);
			else if (shapes[i] instanceof Rectangle)
				((Rectangle) shapes[i]).draw(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));

		
		// After using adapter: clean, general, elegant
		Shape[] shapesArr = { new LineShape(), new RectangleShape() };
		// A begin and end point from a graphical editor
		int px1 = 10, py1 = 20;
		int px2 = 30, py2 = 60;
		for (int i = 0; i < shapesArr.length; ++i)
			shapesArr[i].draw(x1, y1, x2, y2);

	}

}
