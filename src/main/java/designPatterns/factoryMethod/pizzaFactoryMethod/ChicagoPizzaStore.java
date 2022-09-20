package designPatterns.factoryMethod.pizzaFactoryMethod;

/** A part of the Factory Method Pattern example.
 * From Head First Design Patterns book.
 */
public class ChicagoPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String item) {
        	if (item.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (item.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}
