package designPatterns.decorator.shapes;

// Decorator Pattern Example
// The example is based on  https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
public class Rectangle implements Drawable {
	private double width, height = 0;

	public Rectangle() { width = height = 1; }

	public Rectangle(int w, int h) {
		this.width = w;
		this.height = h;
	}
	
	public void setWidth(double w) {
		width = w;
	}
	
	public void setHeight(double h) {
		height = h;
	}

	@Override
	public void draw() {
		System.out.println("Rectangle: " + width + " " + height);
		// code here that draws a rectangle
	}
	
	
	
	
}
