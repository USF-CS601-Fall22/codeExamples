package designPatterns.factoryMethod.naiveApproachPoorDesign;

import designPatterns.factoryMethod.simplePizzaFactory.Pizza;

public class PizzaStoreV1TestDrive {

	// PizzaStoreV1 is a poor design, since it does not follow the Open/Closed principle
	public static void main(String[] args) { ;
		PizzaStoreV1 store = new PizzaStoreV1();

		Pizza pizza = store.orderPizza("cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
 
		pizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
	}
}
