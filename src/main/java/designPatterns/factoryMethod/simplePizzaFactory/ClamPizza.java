package designPatterns.factoryMethod.simplePizzaFactory;

public class ClamPizza extends Pizza {
	public ClamPizza() {
		setName("Clam Pizza");
		setDough("Thin crust");
		setSauce("White garlic sauce");
		addTopping("Clams");
		addTopping("Grated parmesan cheese");
	}
}
