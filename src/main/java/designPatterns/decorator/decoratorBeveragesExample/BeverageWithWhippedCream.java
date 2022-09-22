package designPatterns.decorator.decoratorBeveragesExample;

/** The decorator: adds Whipped cream to the Beverage
 *  The code is modified from the Head First Design Pattern book.
 *
 */
public class BeverageWithWhippedCream extends CondimentDecorator {

	public BeverageWithWhippedCream(Beverage beverage) {
		super(beverage);
	}
 
	public String getDescription() {
		return getBeverage().getDescription() + ", Whipped cream";
	}
 
	public double cost() {
		return .10 + getBeverage().cost();
	}
}
