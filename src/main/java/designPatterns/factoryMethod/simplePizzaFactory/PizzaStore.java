package designPatterns.factoryMethod.simplePizzaFactory;

/** Using a simple factory. This is better than PizzaStoreV1, since we encapsulated things that may change */
public class PizzaStore {
	private SimplePizzaFactory factory;
 
	public PizzaStore(SimplePizzaFactory factory) { 
		this.factory = factory;
	}
 
	public Pizza orderPizza(String type) {
		Pizza pizza;
 
		pizza = factory.createPizza(type);
 
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
