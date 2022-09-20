package designPatterns.factoryMethod.naiveApproachPoorDesign;

import designPatterns.factoryMethod.simplePizzaFactory.*;

/** This is our first version of the Pizza Store. This is a poor implementation since it breaks
 * the design principle that says that we should make each class "open for extension, closed to modification".
 *
 */
public class PizzaStoreV1 {

    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

}
