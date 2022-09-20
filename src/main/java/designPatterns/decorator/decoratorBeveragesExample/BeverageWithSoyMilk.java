package designPatterns.decorator.decoratorBeveragesExample;


/** The decorator: adds Soy Milk to the Beverage
 *  The code is modified from Head First Design Pattern book.
 *
 */
public class BeverageWithSoyMilk extends CondimentDecorator {
	private Beverage beverage;

	public BeverageWithSoyMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}
}
