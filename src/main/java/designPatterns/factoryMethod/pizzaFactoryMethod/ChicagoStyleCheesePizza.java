package designPatterns.factoryMethod.pizzaFactoryMethod;

public class ChicagoStyleCheesePizza extends Pizza {

	public ChicagoStyleCheesePizza() { 
		setName("Chicago Style Deep Dish Cheese Pizza");
		setDough("Extra Thick Crust Dough");
		setSauce("Plum Tomato Sauce");
 
		addTopping("Shredded Mozzarella Cheese");
	}

	@Override
	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
