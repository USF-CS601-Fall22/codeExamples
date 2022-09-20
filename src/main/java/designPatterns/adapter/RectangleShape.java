package designPatterns.adapter;
/**
 * Adapter pattern example
 * Modified from https://sourcemaking.com/design_patterns/adapter/java/1 */

public class RectangleShape implements Shape {
	private Rectangle rec = new Rectangle();

	@Override
	public void draw(int x1, int y1, int x2, int y2) {
		rec.draw(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
	}

}
