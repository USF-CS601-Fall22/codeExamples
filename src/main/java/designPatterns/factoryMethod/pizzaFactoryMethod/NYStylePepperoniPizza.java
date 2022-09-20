package designPatterns.factoryMethod.pizzaFactoryMethod;

public class NYStylePepperoniPizza extends Pizza {

	public NYStylePepperoniPizza() {
		setName("NY Style Pepperoni Pizza");
		setDough("Thin Crust Dough");
		setSauce("Marinara Sauce");
 
		addTopping("Grated Reggiano Cheese");
		addTopping("Sliced Pepperoni");
		addTopping("Garlic");
		addTopping("Onion");
		addTopping("Mushrooms");
	}
}
