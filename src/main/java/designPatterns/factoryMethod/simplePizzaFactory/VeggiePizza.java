package designPatterns.factoryMethod.simplePizzaFactory;

public class VeggiePizza extends Pizza {
	public VeggiePizza() {
		setName("Veggie Pizza");
		setDough("Crust");
		setSauce("Marinara sauce");
		addTopping("Shredded mozzarella");
		addTopping("Grated parmesan");
		addTopping("Diced onion");
		addTopping("Sliced mushrooms");
		addTopping("Sliced red pepper");
		addTopping("Sliced black olives");
	}
}
