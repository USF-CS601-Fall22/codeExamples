package designPatterns.decorator.decoratorBeveragesExample;

/** The decorator: adds Whipped cream to the Beverage
 *  The code is modified from the Head First Design Pattern book.
 *
 */
public class BeverageWithWhippedCream extends CondimentDecorator {
	Beverage beverage;
 
	public BeverageWithWhippedCream(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whipped cream";
	}
 
	public double cost() {
		return .10 + beverage.cost();
	}
}
