package designPatterns.decorator.decoratorBeveragesExample;

/**  The code is from Head First Design Pattern book.
 *
 */
public abstract class CondimentDecorator extends Beverage {
	private Beverage beverage;

	public CondimentDecorator(Beverage beverage) {
		this.beverage = beverage;
	}
	public abstract String getDescription();

	protected Beverage getBeverage() {
		return beverage;
	}
}
