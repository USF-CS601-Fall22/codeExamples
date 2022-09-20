package designPatterns.decorator.decoratorBeveragesExample;

/** The example demonstrates how to use the Decorator pattern.
 *  The code is from Head First Design Pattern book.
 *
 */
public class Decaf extends Beverage {

	public Decaf() {
		description = "Decaf Coffee";
	}
 
	public double cost() {
		return 1.05;
	}
}

