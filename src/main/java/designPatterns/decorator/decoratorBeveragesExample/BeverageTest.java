package designPatterns.decorator.decoratorBeveragesExample;
/** The example demonstrates how to use the Decorator pattern.
 *  The code is from Head First Design Pattern book.
 *
 */

public class BeverageTest {
 
	public static void main(String args[]) {
		Beverage beverage1 = new Espresso();
		System.out.println(beverage1.getDescription() 
				+ " $" + beverage1.cost());
		beverage1 = new BeverageWithMilk(beverage1);
		System.out.println(beverage1.getDescription() 
				+ " $" + beverage1.cost());
		
		Beverage beverage2 = new Decaf();
		beverage2 = new BeverageWithMilk(beverage2);
		beverage2 = new BeverageWithWhippedCream(beverage2);
		System.out.println(beverage2.getDescription() 
				+ " $" + beverage2.cost());


	}
}
