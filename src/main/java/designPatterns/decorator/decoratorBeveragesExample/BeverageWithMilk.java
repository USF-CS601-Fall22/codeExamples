package designPatterns.decorator.decoratorBeveragesExample;

/** The decorator: adds Milk to the Beverage
 *  The code is modified from Head First Design Pattern book.
 *
 */
public class BeverageWithMilk extends CondimentDecorator {
	private Beverage beverage;

	public BeverageWithMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost();
	}
}
