package designPatterns.adapter;

/** Modified from https://sourcemaking.com/design_patterns/adapter/java/1 */

public class Rectangle {

	public void draw(int x, int y, int w, int h) {
		System.out.println("rectangle at (" + x + ',' + y + ") with width " + w + " and height " + h);
	}

}
