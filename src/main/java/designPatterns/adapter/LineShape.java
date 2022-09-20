package designPatterns.adapter;
/** 
 * Adapter pattern example
 * Modified from https://sourcemaking.com/design_patterns/adapter/java/1 */

public class LineShape implements Shape{
	private Line line = new Line();
	
	@Override
	public void draw(int x1, int y1, int x2, int y2) {
		line.draw(x1, y1, x2, y2);
	}

}
