package designPatterns.factoryMethod.pizzaFactoryMethod;

/** A part of the Factory Method Pattern example.
 * From Head First Design Patterns book.
 */
public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
	}
}
