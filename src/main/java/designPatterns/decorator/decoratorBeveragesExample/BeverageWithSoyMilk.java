package designPatterns.decorator.decoratorBeveragesExample;


/** The decorator: adds Soy Milk to the Beverage
 *  The code is modified from Head First Design Pattern book.
 *
 */
public class BeverageWithSoyMilk extends CondimentDecorator {

	public BeverageWithSoyMilk(Beverage beverage) {
		super(beverage);
	}

	public String getDescription() {
		return getBeverage().getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + getBeverage().cost();
	}
}
