package designPatterns.adapter;

/** Modified from https://sourcemaking.com/design_patterns/adapter/java/1 */

public class Line {
	public void draw(int x1, int y1, int x2, int y2) {
        System.out.println("line from (" + x1 + ',' + y1 + ") to (" + x2 + ','  + y2 + ')');
    }
}
