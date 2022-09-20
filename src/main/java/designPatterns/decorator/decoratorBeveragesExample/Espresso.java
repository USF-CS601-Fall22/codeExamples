package designPatterns.decorator.decoratorBeveragesExample;

/** The example demonstrates how to use the Decorator pattern.
 *  The code is from Head First Design Pattern book.
 *
 */
public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}

