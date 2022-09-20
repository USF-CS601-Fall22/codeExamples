package designPatterns.decorator.decoratorBeveragesExample;

/** Class Beverage, a super class for two types of coffee drinks: Expresso and Decaf 
 * The code is from Head First Design Pattern book.
 *
 */
public abstract class Beverage {
	String description = "Unknown Beverage";
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();
	
}
