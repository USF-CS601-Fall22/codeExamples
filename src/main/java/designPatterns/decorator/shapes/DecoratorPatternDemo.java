package designPatterns.decorator.shapes;
//Decorator Pattern Example
//The example is based on  https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm

public class DecoratorPatternDemo {
	   public static void main(String[] args) {
	      Drawable circle = new Circle();
	      circle.draw();

	      Drawable redCircle = new BorderDecorator(new Circle());
	      System.out.println("\nCircle with red border");
	      redCircle.draw();
	      
	      Drawable redRectangle = new BorderDecorator(new Rectangle());
	      System.out.println("\nRectangle of red border");
	      redRectangle.draw();
	   }
	}