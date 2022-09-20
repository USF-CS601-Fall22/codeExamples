package designPatterns.decorator.shapes;

//Decorator Pattern Example
//The example is based on  https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
public abstract class ShapeDecorator implements Drawable {
	private Drawable decoratedShape;

	public ShapeDecorator(Drawable decoratedShape){
	      this.decoratedShape = decoratedShape;
	   }

	@Override
	public void draw(){
		decoratedShape.draw();
	}

	public Drawable getDecoratedShape () {
		return decoratedShape;
	}

}
