package designPatterns.builder;


/** Creating an object without Builder pattern, using default constructor and set methods.
 *  The issues with this approach:
 *  - object might be in inconsistent state and
 *  - it is not possible to make the class immutable.
 *  Builder pattern (see class NutritionFactsWithBuilder) overcomes both of these issues, and
 *  is a better solution.
 *  From "Effective Java" by Joshua Bloch. */
public class NutritionFactsSetMethods {
    // Parameters initialized to default values (if any) - can no longer be final
    private int servingSize  = -1; // Required; no default value
    private int servings     = -1; // Required; no default value
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;

    /**
     * Default constructor
     */
    public NutritionFactsSetMethods() { }

    // Set methods for instance variables
    public void setServingSize(int servingSize)  { this.servingSize = servingSize; }
    public void setServings(int servings)     { this.servings = servings; }
    public void setCalories(int calories)     { this.calories = calories; }
    public void setFat(int fat)          { this.fat = fat; }
    public void setSodium(int sodium)       { this.sodium = sodium; }
    public void setCarbohydrate(int carbohydrate) { this.carbohydrate = carbohydrate; }


    public static void main(String[] args) {
        // Creating a object using default constructor and set methods
        // Cannot do validity checks to make sure the object is in a consistent state.
        // Cannot make the object immutable
        NutritionFactsSetMethods nf = new NutritionFactsSetMethods();
        nf.setServings(2);
        nf.setServingSize(3);
        nf.setFat(1);

    }
}

