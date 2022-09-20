package designPatterns.factoryMethod.simplePizzaFactory;

public class PepperoniPizza extends Pizza {
	public PepperoniPizza() {
		setName("Pepperoni Pizza");
		setDough("Crust");
		setSauce("Marinara sauce");
		addTopping("Sliced Pepperoni");
		addTopping("Sliced Onion");
		addTopping("Grated parmesan cheese");
	}
}
